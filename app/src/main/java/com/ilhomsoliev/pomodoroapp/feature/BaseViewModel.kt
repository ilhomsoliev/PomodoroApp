package com.ilhomsoliev.pomodoroapp.feature

import androidx.lifecycle.ViewModel
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType

class BaseViewModel : ViewModel() {
    var isActive = false
    var showFinishDialog = false
    var dialogPendingType: SessionType = SessionType.INVALID
    var enableFlashingNotification = false
}