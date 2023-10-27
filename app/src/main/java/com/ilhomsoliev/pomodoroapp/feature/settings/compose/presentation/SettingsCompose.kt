package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsPrefItem
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsTopBar
import com.ilhomsoliev.pomodoroapp.shared.icons.DevelopersIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.LanguagesIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.NotificationIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.ThemeIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.TimeIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.VibrateIcon

data class SettingsState(
    val isDarkTheme: Boolean,
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
        LazyColumn(content = {
            item(key = 1) {
                SettingsPrefItem(
                    icon = TimeIcon,
                    title = "Timer duration",
                    description = "Set the duration for work and break session",
                )
            }
            item(key = 2) {
                SettingsPrefItem(
                    icon = ThemeIcon,
                    title = "Dark theme",
                    isToggleActive = false,
                    onToggleClick = {}
                )
            }
            item(key = 3) {
                SettingsPrefItem(
                    icon = NotificationIcon,
                    title = "Notification sound",
                    isToggleActive = false,
                    onToggleClick = {}
                )
            }
            item(key = 4) {
                SettingsPrefItem(
                    icon = VibrateIcon,
                    title = "Vibration",
                    description = "Strong",
                )
            }
            item(key = 6) {
                SettingsPrefItem(
                    icon = LanguagesIcon,
                    title = "Language",
                    description = "English",
                )
            }
            item(key = 7) {
                SettingsPrefItem(
                    icon = DevelopersIcon,
                    title = "Developers",
                )
            }
            /*item(key = 8) {
                SettingsPrefItem(
                    icon = Backgr,
                    title = "Background",
                )
            }*/
            item(key = 8) {

            }
        })
    }

}