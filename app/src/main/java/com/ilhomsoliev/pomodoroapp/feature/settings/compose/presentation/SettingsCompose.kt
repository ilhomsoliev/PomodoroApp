package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsTopBar
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.main_settings.MainSettingsScreen
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.time_duration_screen.TimeDurationScreen
import com.ilhomsoliev.pomodoroapp.shared.bs.DevelopersModalBs
import com.ilhomsoliev.pomodoroapp.shared.dialogs.customDialogs.LanguageSettingsDialog
import com.ilhomsoliev.pomodoroapp.shared.dialogs.customDialogs.VibrationSettingsDialog
import com.ilhomsoliev.pomodoroapp.shared.model.LanguageEnum
import com.ilhomsoliev.pomodoroapp.shared.model.VibrationTypeEnum

data class SettingsState(
    val isDarkTheme: Boolean,
    val isOnTimerDurationScreen: Boolean,
    val isLongBreakToggleActive: Boolean,
    val workTime: Int,
    val shortBreakTime: Int,
    val longBreakTime: Int,
    val isVibrationDialogActive: Boolean,
    val isLanguageDialogActive: Boolean,
    val isDevelopersBsActive: Boolean,
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
    fun onIsVibrationDialogChange(value: Boolean)
    fun onIsLanguageDialogChange(value: Boolean)
    fun onIsDevelopersBsActiveChange(value: Boolean)
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

    DevelopersModalBs(
        showBottomSheet = state.isDevelopersBsActive,
        onDismiss = {
            callback.onIsDevelopersBsActiveChange(false)
        },
    )

    VibrationSettingsDialog(
        isDialogShown = state.isVibrationDialogActive,
        vibrationType = VibrationTypeEnum.None,
        onDismissRequest = {
            callback.onIsVibrationDialogChange(false)
        },
        {
            callback.onIsVibrationDialogChange(false)
        },
        {

            callback.onIsVibrationDialogChange(false)
        })

    LanguageSettingsDialog(
        isDialogShown = state.isLanguageDialogActive,
        vibrationType = LanguageEnum.English,
        onDismissRequest = {
            callback.onIsLanguageDialogChange(false)
        },
        {
            callback.onIsLanguageDialogChange(false)
        },
        {

            callback.onIsLanguageDialogChange(false)
        })
}