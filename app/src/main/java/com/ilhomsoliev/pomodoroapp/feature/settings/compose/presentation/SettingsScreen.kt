package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    vm: SettingsViewModel,
    onBack: () -> Unit,
) {
    val isSystemDark = isSystemInDarkTheme()
    val isOnTimerDurationScreen by vm.isOnTimerDurationScreen.collectAsState()
    val isLongBreakToggleActive by vm.isLongBreakToggleActive.collectAsState()

    SettingsContent(
        SettingsState(
            isDarkTheme = isSystemDark,
            isOnTimerDurationScreen = isOnTimerDurationScreen,
            isLongBreakToggleActive = isLongBreakToggleActive,
        ),
        object : SettingsCallback {
            override fun onBack() {
                if (isOnTimerDurationScreen) {
                    vm.onIsOnTimerDurationScreenChange()
                } else {
                    onBack()
                }
            }

            override fun onTimerDurationClick() {
                vm.onIsOnTimerDurationScreenChange()
            }

            override fun onThemeToggleClick() {
                TODO("Not yet implemented")
            }

            override fun onNotificationToggleClick() {
                TODO("Not yet implemented")
            }

            override fun onVibrationClick() {
                TODO("Not yet implemented")
            }

            override fun onLanguageClick() {
                TODO("Not yet implemented")
            }

            override fun onDevelopersClick() {
                TODO("Not yet implemented")
            }

            override fun onBackgroundClick() {
                TODO("Not yet implemented")
            }

            override fun onDisableSoundAndVibrationClick() {
                TODO("Not yet implemented")
            }

            override fun onDoNotDisturbClick() {
                TODO("Not yet implemented")
            }

            override fun onEnableLongBreaksClick(value: Boolean) {
                vm.onIsLongBreakToggleActiveChange()
            }

        }

    )

}