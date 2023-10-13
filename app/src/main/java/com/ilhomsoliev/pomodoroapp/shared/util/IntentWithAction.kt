package com.ilhomsoliev.pomodoroapp.shared.util

import android.content.Context
import android.content.Intent
import com.ilhomsoliev.pomodoroapp.core.Constants.SESSION_TYPE
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType

class IntentWithAction : Intent {
    constructor(context: Context, cls: Class<*>, action: String) : super(context, cls) {
        this.action = action
    }

    constructor(
        context: Context,
        cls: Class<*>,
        action: String,
        sessionType: SessionType
    ) : super(context, cls) {
        this.action = action
        this.putExtra(SESSION_TYPE, sessionType.toString())
    }
}