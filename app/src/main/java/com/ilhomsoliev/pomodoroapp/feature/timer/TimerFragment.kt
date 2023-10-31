package com.ilhomsoliev.pomodoroapp.feature.timer

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.ContextWrapper
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.Constants
import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.core.extentions.printToLog
import com.ilhomsoliev.pomodoroapp.data.local.Label
import com.ilhomsoliev.pomodoroapp.data.reminders.ReminderHelper.Companion.removeNotification
import com.ilhomsoliev.pomodoroapp.data.timer.CurrentSession
import com.ilhomsoliev.pomodoroapp.data.timer.CurrentSessionManager
import com.ilhomsoliev.pomodoroapp.data.timer.NotificationHelper
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType
import com.ilhomsoliev.pomodoroapp.data.timer.TimerService
import com.ilhomsoliev.pomodoroapp.data.timer.TimerState
import com.ilhomsoliev.pomodoroapp.databinding.FragmentTimerBinding
import com.ilhomsoliev.pomodoroapp.feature.timer.components.ButtonTimerMain
import com.ilhomsoliev.pomodoroapp.feature.timer.components.TimerMain
import com.ilhomsoliev.pomodoroapp.feature.timer.components.TopBarMain
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import com.ilhomsoliev.pomodoroapp.shared.util.IntentWithAction
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.concurrent.TimeUnit

class TimerFragment : AbsMainActivityFragment(R.layout.fragment_timer),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var _binding: TimerBinding? = null
    private val binding get() = _binding!!

    private val currentSessionManager by this.getKoin().inject<CurrentSessionManager>()

    private var sessionFinishedDialog: FinishedSessionDialog? = null

    private val contextKoin by this.getKoin().inject<Context>()

    private val contextFragment = this.context

    private var currentSessionType = SessionType.INVALID
    private val currentSession: CurrentSession
        get() = currentSessionManager.currentSession

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBinding = FragmentTimerBinding.bind(view)
        _binding = TimerBinding(homeBinding)

        if (PreferenceUtil.isFirstRun) {
            // show app intro
        }
        val overalltime = PreferenceUtil.getSessionDuration(SessionType.WORK)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    val controller = rememberSystemUiController()

                    LaunchedEffect(key1 = Unit, block = {
                        controller.setSystemBarsColor(Color(0xFFFFFFFF))
                        controller.setNavigationBarColor(Color(0xFFFFFFFF))
                        controller.setStatusBarColor(Color(0xFFFFFFFF))
                    })

                    val duration by currentSession.duration.observeAsState()
                    val timerState by currentSession.timerState.observeAsState()
                    val sessionType by currentSession.sessionType.observeAsState()

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        TopBarMain(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            findNavController().navigate(
                                R.id.action_settings, null, null, null
                            )
                        }

                        TimerMain(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2.5f),
                            onClick = { onStartButtonClick() },
                            overalltime = overalltime.toInt() * 60,
                            duration = duration?.toInt()?.div(1000) ?: 0,
                            isInActive = timerState == TimerState.INACTIVE,
                            sessionType = sessionType,
                        )

                        ButtonTimerMain(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1.5f),
                            timerState = timerState,
                            onSkipButtonClick = { onSkipButtonClick() },
                            onStartButtonClick = { onStartButtonClick() },

                            )
                    }
                }
            }
        }

        setupListeners()
        setupEvents()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    @Subscribe
    fun onEventMainThread(o: Any?) {
        // TODO
        o.printToLog("onEventMainThread TimerFragment")
        if (o is Constants.FinishWorkEvent) {
            (o).printToLog("Hello on Event FinishWorkEvent")
            if (PreferenceUtil.isAutoStartBreak || true) {
                /*if (PreferenceUtil.isFlashingNotificationEnabled()) {
                    baseViewModel.enableFlashingNotification = true
                }*/
            } else {
                baseViewModel.dialogPendingType = SessionType.WORK
                // showFinishedSessionUI()
            }
        } else if (o is Constants.FinishBreakEvent || o is Constants.FinishLongBreakEvent) {
            (o).printToLog("Hello on Event FinishBreakEvent")
            /*if (PreferenceUtil.isAutoStartWork()) {
                if (PreferenceUtil.isFlashingNotificationEnabled()) {
                    baseViewModel.enableFlashingNotification = true
                }
            } else {
                baseViewModel.dialogPendingType = SessionType.BREAK
                 showFinishedSessionUI()
            }*/
        } else if (o is Constants.StartSessionEvent) {
            (o).printToLog("Hello on Event StartSessionEvent")
            if (sessionFinishedDialog != null) {
                sessionFinishedDialog!!.dismissAllowingStateLoss()
            }
            baseViewModel.showFinishDialog = false
            if (!PreferenceUtil.isAutoStartBreak && !PreferenceUtil.isAutoStartWork) {
                stopFlashingNotification()
            }
        } else if (o is Constants.OneMinuteLeft) {
            (o).printToLog("Hello on Event OneMinuteLeft")
            /*if (PreferenceUtil.isFlashingNotificationEnabled()) {
                startFlashingNotificationShort()
            }*/
        }
    }

    private fun stopFlashingNotification() {
        baseViewModel.enableFlashingNotification = false
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupListeners() {
        /*binding.timeView.setOnTouchListener(object :
            OnSwipeTouchListener(this@TimerFragment.activity) {
            public override fun onSwipeRight(view: View) {
                onSkipSession()
            }

            public override fun onSwipeLeft(view: View) {
                onSkipSession()
            }

            public override fun onSwipeBottom(view: View) {
                onStopSession()
                if (true *//*preferenceHelper.isScreensaverEnabled()*//*) {
                    activity?.let { recreate(it) }
                }
            }

            public override fun onSwipeTop(view: View) {
                if (currentSession.timerState.value !== TimerState.INACTIVE) {
                    onAdd60SecondsButtonClick()
                }
            }

            public override fun onClick(view: View) {
                onStartButtonClick(view)
            }

            public override fun onLongClick(view: View) {
                // TODO Go to Settings
                *//*val settingsIntent = Intent(this@TimerFragment.activity, SettingsActivity::class.java)
                startActivity(settingsIntent)*//*
            }

            public override fun onPress(view: View) {
                binding.timeView.startAnimation(
                    AnimationUtils.loadAnimation(
                        contextKoin, R.anim.scale_reversed
                    )
                )
            }

            public override fun onRelease(view: View) {
                binding.timeView.startAnimation(
                    AnimationUtils.loadAnimation(
                        contextKoin, R.anim.scale
                    )
                )
                if (currentSession.timerState.value === TimerState.PAUSED) {
                    lifecycleScope.launch {
                        delay(300)
                        binding.timeView.startAnimation(
                            AnimationUtils.loadAnimation(
                                contextKoin,
                                R.anim.blink
                            )
                        )
                    }
                }
            }
        })*/
    }

    fun onStartButtonClick() {
        start(SessionType.WORK)
    }

    fun onAdd60SecondsButtonClick() {
        add60Seconds()
    }

    private fun add60Seconds() {
        val stopIntent: Intent = IntentWithAction(
            contextKoin,
            TimerService::class.java,
            Constants.ACTION.ADD_SECONDS
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            contextKoin.startForegroundService(stopIntent)
        } else {
            contextKoin.startService(stopIntent)
        }
    }

    private fun onStopButtonClick() {
        stop()
    }

    private fun onSkipButtonClick() {
        skip()
    }

    private fun onSkipSession() {
        if (currentSession.timerState.value !== TimerState.INACTIVE) {
            onSkipButtonClick()
        }
    }

    private fun onStopSession() {
        if (currentSession.timerState.value !== TimerState.INACTIVE) {
            onStopButtonClick()
        }
    }

    private fun skip() {
        if (currentSession.timerState.value !== TimerState.INACTIVE) {
            val skipIntent: Intent = IntentWithAction(
                contextKoin, TimerService::class.java,
                Constants.ACTION.SKIP
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                contextKoin.startForegroundService(skipIntent)
            } else {
                contextKoin.startService(skipIntent)
            }
        }
    }

    /*
        override fun onAttachedToWindow() {
            */
    /*window.addFlags(
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
            )*//*

    }
*/

    override fun onPause() {
        super.onPause()
        baseViewModel.isActive = false
    }

    override fun onResume() {
        super.onResume()
        removeNotification(contextKoin)
        baseViewModel.isActive = true
        if (baseViewModel.showFinishDialog) {
            // showFinishedSessionUI()
        }

        // initialize notification channels on the first run
        if (PreferenceUtil.isFirstRun) {
            NotificationHelper(this@TimerFragment.contextKoin)
        }

        // this is to refresh the current status icon color
        // invalidateOptionsMenu()
        /*val pref = PreferenceManager.getDefaultSharedPreferences(context)
       pref.registerOnSharedPreferenceChangeListener(context)*//*
        PreferenceUtil.registerOnSharedPreferenceChangedListener(this@TimerFragment)

        toggleKeepScreenOn(preferenceHelper.isScreenOnEnabled())
        toggleFullscreenMode()
        showTutorialSnackbars()
        setTimeLabelColor()
        blackCover.animate().alpha(0f).duration = 500

        // the only reason we're doing this here is because a FinishSessionEvent
        // comes together with a "bring activity on top"
        if (preferenceHelper.isFlashingNotificationEnabled() && mainViewModel.enableFlashingNotification) {
            whiteCover.visibility = View.VISIBLE
            if (preferenceHelper.isAutoStartBreak() && (currentSessionType === SessionType.BREAK || currentSessionType === SessionType.LONG_BREAK)
                || preferenceHelper.isAutoStartWork() && currentSessionType === SessionType.WORK
            ) {
                startFlashingNotificationShort()
            } else {
                startFlashingNotification()
            }
        }*/
    }

    private fun setupEvents() {
        currentSession.duration.observe(
            viewLifecycleOwner
        ) { millis: Long ->
            updateTimeLabel(millis)
        }

        currentSession.sessionType.observe(viewLifecycleOwner) { sessionType: SessionType ->
            currentSessionType = sessionType
            // setupLabelView()
            // setTimeLabelColor()
        }

        /*currentSession.timerState.observe(viewLifecycleOwner) { timerState: TimerState ->
            when {
                timerState === TimerState.INACTIVE -> {
                    setupLabelView()
                    setTimeLabelColor()
                    lifecycleScope.launch {
                        delay(300)
                        // binding.timeView.clearAnimation()
                    }
                }

                timerState === TimerState.PAUSED -> {
                    lifecycleScope.launch {
                        delay(300)
                        // binding.timeView.startAnimation(AnimationUtils.loadAnimation(contextKoin, R.anim.blink))
                    }
                }

                else -> {
                    lifecycleScope.launch {
                        delay(300)
                        // binding.timeView.clearAnimation()
                    }
                }
            }
        }*/
    }

    private fun isInvalidLabel(label: Label): Boolean {
        return label.title == "" || label.title == getString(R.string.label_unlabeled)
    }

    private fun updateTimeLabel(millis: Long) {
        var seconds = TimeUnit.MILLISECONDS.toSeconds(millis)
        val minutes = TimeUnit.SECONDS.toMinutes(seconds)
        seconds -= minutes * 60
        val currentFormattedTick: String
        val isMinutesStyle =
            false// TODO preferenceHelper.timerStyle == resources.getString(R.string.pref_timer_style_minutes_value)
        currentFormattedTick = if (isMinutesStyle) {
            TimeUnit.SECONDS.toMinutes(minutes * 60 + seconds + 59).toString()
        } else {
            ((if (minutes > 9) minutes else "0$minutes")
                .toString() + ":"
                    + if (seconds > 9) seconds else "0$seconds")
        }
        // binding.timeView.text = currentFormattedTick
        Log.v(TAG, "drawing the time label.")
        // TODO
        /*if (preferenceHelper.isScreensaverEnabled() && seconds == 1L && currentSession.timerState.value !== TimerState.PAUSED) {
            teleportTimeView()
        }*/
    }

    private fun scheduleAlarmPermissionGranted(): Boolean {
        val alarmManager: AlarmManager =
            this@TimerFragment.activity?.getSystemService(ALARM_SERVICE) as AlarmManager
        return if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
                    && Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU)
            && !alarmManager.canScheduleExactAlarms()
        ) {
            showAlarmPermissionSnackbar()
            false
        } else {
            true
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun showAlarmPermissionSnackbar() {
        /*        val s = Snackbar.make(
                    binding.toolbar,
                    "getString(R.string.settings_grant_permission)",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction(getString(android.R.string.ok)) {
                        askForAlarmPermission(ContextWrapper(this@TimerFragment.activity?.baseContext))
                    }
                    .setAnchorView(binding.toolbar)
                s.behavior = object : BaseTransientBottomBar.Behavior() {
                    override fun canSwipeDismissView(child: View): Boolean {
                        return false
                    }
                }
                s.show()*/
    }

    @RequiresApi(Build.VERSION_CODES.S)
    fun askForAlarmPermission(contextWrapper: ContextWrapper) {
        val intent = Intent().apply {
            action = Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM
        }
        contextWrapper.startActivity(intent)
    }

    private fun start(sessionType: SessionType) {
        if (!scheduleAlarmPermissionGranted()) return
        var startIntent = Intent()
        when (currentSession.timerState.value) {
            TimerState.INACTIVE -> startIntent = IntentWithAction(
                contextKoin, TimerService::class.java,
                Constants.ACTION.START, sessionType
            )

            TimerState.ACTIVE, TimerState.PAUSED -> startIntent = IntentWithAction(
                contextKoin,
                TimerService::class.java,
                Constants.ACTION.TOGGLE
            )

            else -> Log.wtf(TAG, "Invalid timer state.")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this@TimerFragment.activity?.startForegroundService(startIntent)
        } else {
            this@TimerFragment.activity?.startService(startIntent)
        }
    }

    private fun stop() {
        val stopIntent: Intent =
            IntentWithAction(contextKoin, TimerService::class.java, Constants.ACTION.STOP)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            contextKoin.startForegroundService(stopIntent)
        } else {
            contextKoin.startService(stopIntent)
        }
    }

    override fun onDestroy() {
        val pref = PreferenceManager.getDefaultSharedPreferences(contextKoin)
        pref.unregisterOnSharedPreferenceChangeListener(this)
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        // TODO
    }

    companion object {
        private val TAG = TimerFragment::class.java.simpleName
        private const val DIALOG_SELECT_LABEL_TAG = "dialogSelectLabel"

        @JvmStatic
        fun newInstance(): TimerFragment {
            return TimerFragment()
        }
    }

}
