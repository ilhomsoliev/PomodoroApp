package com.ilhomsoliev.pomodoroapp.data.reminders

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import org.koin.core.component.KoinComponent

class BootReceiver : BroadcastReceiver(), KoinComponent {

    private val reminderHelper: ReminderHelper by this.getKoin().inject<ReminderHelper>()

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == null) return
        try {
            if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
                Log.d(TAG, "onBootComplete")
                reminderHelper.scheduleNotifications()
            }
        } catch (e: RuntimeException) {
            Log.wtf(TAG, "Could not process intent")
        }
    }

    companion object {
        private const val TAG = "BootReceiver"
    }
}
