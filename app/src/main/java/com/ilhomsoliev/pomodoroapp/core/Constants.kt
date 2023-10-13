package com.ilhomsoliev.pomodoroapp.core

object Constants {

    // TODO change names
    const val ONE_MINUTE_LEFT = "goodtime.one.minute.left"
    const val SESSION_TYPE = "goodtime.session.type"

    interface ACTION {
        companion object {
            const val START = "goodtime.action.start"
            const val SKIP = "goodtime.action.skip"
            const val TOGGLE = "goodtime.action.toggle"
            const val STOP = "goodtime.action.stop"
            const val FINISHED = "goodtime.action.finished"
            const val ADD_SECONDS = "goodtime.action.addseconds"
        }
    }
    class FinishWorkEvent
    class FinishBreakEvent
    class FinishLongBreakEvent
    class UpdateTimerProgressEvent
    class ClearNotificationEvent
    class StartSessionEvent
    class OneMinuteLeft
}

const val CURRENT_SESSION_LABEL = "CURRENT_SESSION_LABEL"
const val CURRENT_SESSION_COLOR = "CURRENT_SESSION_COLOR"
const val LANGUAGE_NAME = "language_name"
const val WORK_DURATION = "WORK_DURATION"
const val BREAK_DURATION = "BREAK_DURATION"
const val LONG_BREAK_DURATION = "LONG_BREAK_DURATION"
const val TOGGLE_FULL_SCREEN = "toggle_full_screen"
const val IS_FIRST_RUN = "IS_FIRST_RUN"
const val ENABLE_ONE_MINUTE_BEFORE_NOTIFICATION = "ENABLE_ONE_MINUTE_BEFORE_NOTIFICATION"
const val ADD_60_SECONDS_COUNTER = "ADD_60_SECONDS_COUNTER"
const val GENERAL_THEME = "general_theme"
const val BLACK_THEME = "black_theme"
const val MATERIAL_YOU = "material_you"
const val LOCALE_AUTO_STORE_ENABLED = "locale_auto_store_enabled"
