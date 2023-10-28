package com.ilhomsoliev.pomodoroapp.data.timer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.ilhomsoliev.pomodoroapp.core.Constants
import org.greenrobot.eventbus.EventBus

class AlarmReceiver(private val listener: OnAlarmReceivedListener) : BroadcastReceiver() {

    interface OnAlarmReceivedListener {
        fun onAlarmReceived()
    }

    companion object {
        private val TAG = AlarmReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context, intent: Intent) {
        val oneMinuteLeft = intent.getBooleanExtra(Constants.ONE_MINUTE_LEFT, false)
        if (oneMinuteLeft) {
            Log.v(TAG, "onReceive oneMinuteLeft")
            EventBus.getDefault().post(Constants.OneMinuteLeft())
            return
        }
        val sessionType = SessionType.valueOf(intent.getStringExtra(Constants.SESSION_TYPE)!!)
        Log.v(TAG, "onReceive $sessionType")

        listener.onAlarmReceived()

        when (sessionType) {
            SessionType.WORK -> EventBus.getDefault().post(Constants.FinishWorkEvent())
            SessionType.BREAK -> EventBus.getDefault().post(Constants.FinishBreakEvent())
            SessionType.LONG_BREAK -> EventBus.getDefault().post(Constants.FinishLongBreakEvent())
            else -> {
            }
        }
    }
}