package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    vm: SettingsViewModel,
    onBack: () -> Unit,
) {
    val isSystemDark = isSystemInDarkTheme()
    SettingsContent(
        SettingsState(isSystemDark),
        object : SettingsCallback {
            override fun onBack() {
                onBack()
            }

            override fun onTimerDurationClick() {
                TODO("Not yet implemented")
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

        }

    )

}