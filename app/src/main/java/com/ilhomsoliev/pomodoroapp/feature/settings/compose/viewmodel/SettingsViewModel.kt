package com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {
    private val _isOnTimerDurationScreen = MutableStateFlow(false)
    val isOnTimerDurationScreen = _isOnTimerDurationScreen.asStateFlow()

    private val _isLongBreakToggleActive = MutableStateFlow(false)
    val isLongBreakToggleActive = _isLongBreakToggleActive.asStateFlow()

    fun onIsOnTimerDurationScreenChange() {
        _isOnTimerDurationScreen.value = !_isOnTimerDurationScreen.value
    }

    fun onIsLongBreakToggleActiveChange() {
        _isLongBreakToggleActive.value = !_isLongBreakToggleActive.value
    }

}