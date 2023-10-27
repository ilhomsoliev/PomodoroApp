package com.ilhomsoliev.pomodoroapp.feature.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.databinding.FragmentSettingsBinding
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsScreen
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.koin.androidx.compose.koinViewModel

class SettingsFragment : AbsMainActivityFragment(R.layout.fragment_settings),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private var _binding: SettingsBinding? = null
    private val binding get() = _binding!!

    private val contextKoin by this.getKoin().inject<Context>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val settingsBinding = FragmentSettingsBinding.bind(view)
        _binding = SettingsBinding(settingsBinding)
        /*mainActivity.setSupportActionBar(binding.toolbar)
        setupToolbarTitle()*/
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    val vm = koinViewModel<SettingsViewModel>()
                    SettingsScreen(vm, onBack = {
                        findNavController().navigateUp()
                    })
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        /*setupTheme()
        setupNotificationPref()
        setupVibration()*/
    }

    private fun setupTheme() {
        /*binding.themePref.toggle.setOnCheckedChangeListener { buttonView, isChecked ->
            // TODO
            *//*ThemeHelper.setTheme(activity as SettingsActivity, preferenceHelper.isAmoledTheme())
            requireActivity().recreate()
            true*//*
        }*/
        /*val prefAmoled = findPreference<SwitchPreferenceCompat>(PreferenceHelper.AMOLED)
        prefAmoled!!.onPreferenceClickListener =
            if (preferenceHelper.isPro()) null else Preference.OnPreferenceClickListener {
                launchUpgradeDialog(requireActivity().supportFragmentManager)
                prefAmoled.isChecked = true
                true
            }
        prefAmoled.onPreferenceChangeListener =
            if (preferenceHelper.isPro()) Preference.OnPreferenceChangeListener { _, _ ->
                ThemeHelper.setTheme(activity as SettingsActivity, preferenceHelper.isAmoledTheme())
                requireActivity().recreate()
                true
            } else null*/
    }

    private fun setupNotificationPref() {
        /*binding.notificationSoundPref.toggle.setOnCheckedChangeListener { buttonView, isChecked ->
            // TODO
        }*/
    }

    private fun setupVibration() {
        /*binding.vibrationSoundPref.root.setOnClickListener {

        }*/
    }

    private fun setupToolbarTitle() {
        /*binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val appName = "Settings"
        binding.toolbar.title = appName

        binding.timerDurationPref.root.setOnClickListener {
            Toast.makeText(this@SettingsFragment.contextKoin, "Hey", Toast.LENGTH_LONG).show()
        }*/
    }

    override fun onSharedPreferenceChanged(
        sharedPreferences: SharedPreferences?,
        key: String?
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)

    }

    @Subscribe
    fun onEventMainThread(o: Any?) {

    }

}