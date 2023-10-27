package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.main_settings

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsCallback
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsState
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsPrefItem
import com.ilhomsoliev.pomodoroapp.shared.icons.DevelopersIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.LanguagesIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.NotificationIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.ThemeIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.TimeIcon
import com.ilhomsoliev.pomodoroapp.shared.icons.VibrateIcon

@Composable
fun MainSettingsScreen(
    state: SettingsState,
    callback: SettingsCallback,
) {
    LazyColumn(content = {
        item(key = 1) {
            SettingsPrefItem(
                icon = TimeIcon,
                title = "Timer duration",
                description = "Set the duration for work and break session",
                onClick = {
                    callback.onTimerDurationClick()
                }
            )
        }
        item(key = 2) {
            SettingsPrefItem(
                icon = ThemeIcon,
                title = "Dark theme",
                isToggleActive = false,
                onToggleClick = {},
                onClick = {
                    callback.onThemeToggleClick()

                }
            )
        }
        item(key = 3) {
            SettingsPrefItem(
                icon = NotificationIcon,
                title = "Notification sound",
                isToggleActive = false,
                onToggleClick = {},
                onClick = {
                    callback.onNotificationToggleClick()
                }
            )
        }
        item(key = 4) {
            SettingsPrefItem(
                icon = VibrateIcon,
                title = "Vibration",
                description = "Strong",
                onClick = {
                    callback.onVibrationClick()
                })
        }
        item(key = 6) {
            SettingsPrefItem(
                icon = LanguagesIcon,
                title = "Language",
                description = "English",
                onClick = {
                    callback.onLanguageClick()
                })
        }
        item(key = 7) {
            SettingsPrefItem(
                icon = DevelopersIcon,
                title = "Developers",
                onClick = {
                    callback.onDevelopersClick()
                }
            )
        }
        item(key = 9) {
            SettingsPrefItem(
                icon = DevelopersIcon,
                title = "Background",
                onClick = {}
            )
        }
        item(key = 10) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 22.dp, bottom = 18.dp),
                text = "During work session",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.dm_sans)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6200EE),
                )
            )
        }
        item(key = 11) {
            SettingsPrefItem(
                title = "Disable sound and vibration",
                description = "Click to grant permission",
                onClick = {},
                isCheckboxActive = true,
                onToggleClick = {
                    callback.onDisableSoundAndVibrationClick()
                }
            )
        }
        item(key = 12) {
            SettingsPrefItem(
                title = "Do not disturb mode",
                description = "Click to grant permission",
                onClick = {},
                isCheckboxActive = true,
                onToggleClick = {
                    callback.onDoNotDisturbClick()
                }
            )
        }

    })
}