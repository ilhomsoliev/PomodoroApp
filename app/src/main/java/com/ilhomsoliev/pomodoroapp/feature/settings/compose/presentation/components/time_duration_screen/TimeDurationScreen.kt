package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.time_duration_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsCallback
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.SettingsState
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.CustomSliderItem
import com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components.SettingsPrefItem

@Composable
fun TimeDurationScreen(
    state: SettingsState,
    callback: SettingsCallback,
) {
    LazyColumn(content = {
        item(key = 1) {
            SettingsPrefItem(title = "Profile", description = "25/5", hasDivider = false)
            Divider(modifier = Modifier.padding(start = 16.dp))
        }

        item(key = 2) {
            CustomSliderItem(title = "Work Time", currentValue = state.workTime) {
                callback.onWorkTimeChange(it)
            }
        }
        item(key = 3) {
            CustomSliderItem(title = "Short break", currentValue = state.shortBreakTime) {

            }
        }
        item(key = 4) {
            SettingsPrefItem(
                title = "Enable long breaks",
                isToggleActive = state.isLongBreakToggleActive,
                onToggleClick = { value ->
                    callback.onEnableLongBreaksClick(value)
                }, hasDivider = false
            )
        }
    })


}