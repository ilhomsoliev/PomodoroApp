package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsTopBar
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.main_settings.MainSettingsScreen
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.time_duration_screen.TimeDurationScreen

data class SettingsState(
    val isDarkTheme: Boolean,
    val isOnTimerDurationScreen: Boolean,
    val isLongBreakToggleActive: Boolean,
    val workTime: Int,
    val shortBreakTime: Int,
    val longBreakTime: Int,
    )

interface SettingsCallback {
    fun onBack()
    fun onTimerDurationClick()
    fun onThemeToggleClick()
    fun onNotificationToggleClick()
    fun onVibrationClick()
    fun onLanguageClick()
    fun onDevelopersClick()
    fun onBackgroundClick()
    fun onDisableSoundAndVibrationClick()
    fun onDoNotDisturbClick()
    fun onEnableLongBreaksClick(value: Boolean)
    fun onWorkTimeChange(value: Int)
}

@Composable
fun SettingsContent(
    state: SettingsState,
    callback: SettingsCallback,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SettingsTopBar {
            callback.onBack()
        }
        AnimatedContent(targetState = state.isOnTimerDurationScreen, label = "") {
            if (it) {
                TimeDurationScreen(state = state, callback = callback)
            } else {
                MainSettingsScreen(state = state, callback = callback)
            }
        }
    }
}