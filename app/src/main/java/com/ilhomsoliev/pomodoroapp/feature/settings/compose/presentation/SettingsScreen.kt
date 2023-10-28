package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    vm: SettingsViewModel,
    onBack: () -> Unit,
) {

    // Settings Main
    val isSystemDark = isSystemInDarkTheme()
    val isOnTimerDurationScreen by vm.isOnTimerDurationScreen.collectAsState()
    val isLongBreakToggleActive by vm.isLongBreakToggleActive.collectAsState()

    val isVibrationDialogActive = remember { mutableStateOf(false) }
    val isLanguageDialogActive = remember { mutableStateOf(false) }
    // Time and duration
    val workTime by vm.workTime.collectAsState()
    val shortBreakTime by vm.shortBreakTime.collectAsState()
    val longBreakTime by vm.longBreakTime.collectAsState()

    SettingsContent(
        SettingsState(
            isDarkTheme = isSystemDark,
            isOnTimerDurationScreen = isOnTimerDurationScreen,
            isLongBreakToggleActive = isLongBreakToggleActive,
            workTime = workTime ?: 0,
            shortBreakTime = shortBreakTime ?: 0,
            longBreakTime = longBreakTime ?: 0,
            isVibrationDialogActive = isVibrationDialogActive.value,
            isLanguageDialogActive = isLanguageDialogActive.value,
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
                this.onIsVibrationDialogChange(true)
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

            override fun onWorkTimeChange(value: Int) {
                vm.onWorkTimeChange(value)
            }

            override fun onIsVibrationDialogChange(value: Boolean) {
                isVibrationDialogActive.value = value
            }

            override fun onIsLanguageDialogChange(value: Boolean) {
                isLanguageDialogActive.value = value
            }

        }

    )

}