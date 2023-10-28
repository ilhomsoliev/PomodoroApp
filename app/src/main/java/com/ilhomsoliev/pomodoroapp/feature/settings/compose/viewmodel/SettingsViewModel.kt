package com.ilhomsoliev.pomodoroapp.feature.settings.compose.viewmodel

import androidx.lifecycle.ViewModel
import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel(
    preferenceUtil: PreferenceUtil = PreferenceUtil,
) : ViewModel() {
    private val _isOnTimerDurationScreen = MutableStateFlow(false)
    val isOnTimerDurationScreen = _isOnTimerDurationScreen.asStateFlow()

    private val _isLongBreakToggleActive = MutableStateFlow(false)
    val isLongBreakToggleActive = _isLongBreakToggleActive.asStateFlow()

    private val _workTime = MutableStateFlow<Int?>(null)
    val workTime = _workTime.asStateFlow()

    private val _shortBreakTime = MutableStateFlow<Int?>(null)
    val shortBreakTime = _shortBreakTime.asStateFlow()

    private val _longBreakTime = MutableStateFlow<Int?>(null)
    val longBreakTime = _longBreakTime.asStateFlow()

    init {
        val work = preferenceUtil.getSessionDuration(SessionType.WORK)
        val shortBreak = preferenceUtil.getSessionDuration(SessionType.BREAK)
        val longBreak = preferenceUtil.getSessionDuration(SessionType.LONG_BREAK)
        _workTime.value = work.toInt()
        _shortBreakTime.value = shortBreak.toInt()
        _longBreakTime.value = longBreak.toInt()
    }

    fun onIsOnTimerDurationScreenChange() {
        _isOnTimerDurationScreen.value = !_isOnTimerDurationScreen.value
    }

    fun onIsLongBreakToggleActiveChange() {
        _isLongBreakToggleActive.value = !_isLongBreakToggleActive.value
    }

    fun onWorkTimeChange(value: Int) {
        _workTime.value = value
    }


}