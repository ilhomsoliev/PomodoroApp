package com.ilhomsoliev.pomodoroapp.di

import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.data.reminders.BootReceiver
import com.ilhomsoliev.pomodoroapp.data.reminders.ReminderHelper
import com.ilhomsoliev.pomodoroapp.data.timer.CurrentSessionManager
import com.ilhomsoliev.pomodoroapp.data.timer.NotificationHelper
import com.ilhomsoliev.pomodoroapp.data.timer.RingtoneAndVibrationPlayer
import com.ilhomsoliev.pomodoroapp.data.timer.TimerService
import com.ilhomsoliev.pomodoroapp.feature.BaseViewModel
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val viewModules = module {
    viewModel { BaseViewModel() }
    viewModel { SettingsViewModel() }
}

private val dataModule = module {
    single { CurrentSessionManager(get(), PreferenceUtil) }
    single { TimerService() }
    single { PreferenceUtil }
    single { NotificationHelper(get()) }
    single { RingtoneAndVibrationPlayer(get(), get()) }
    single { ReminderHelper(get()) }
    single { BootReceiver() }

}

private val mainModule = module {
    single { androidContext().contentResolver }

}
val appModules = listOf(mainModule, dataModule, viewModules)