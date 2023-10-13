package com.ilhomsoliev.pomodoroapp.core

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.ilhomsoliev.appthemehelper.util.VersionUtils
import com.ilhomsoliev.pomodoroapp.app.PomodoroApplication
import com.ilhomsoliev.pomodoroapp.core.util.theme.ThemeMode
import com.ilhomsoliev.pomodoroapp.data.local.Label
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType

object PreferenceUtil {
    // TODO move to another package
    fun getSessionDuration(sessionType: SessionType?): Long {
        val duration: Long = when (sessionType) {
            SessionType.WORK -> workDuration.toLong()
            SessionType.BREAK -> breakDuration.toLong()
            SessionType.LONG_BREAK -> longDuration.toLong()
            else -> 42
        }
        return duration
    }


    fun resetAdd60SecondsCounter() {
        this.add60SecondsCounter = 0
    }

    fun increment60SecondsCounter() {
        sharedPreferences.edit()
            .putInt(ADD_60_SECONDS_COUNTER, add60SecondsCounter + 1).apply()
    }

    var add60SecondsCounter: Int
        get() = sharedPreferences.getInt(ADD_60_SECONDS_COUNTER, 25) ?: 25
        set(value) = sharedPreferences.edit {
            putInt(ADD_60_SECONDS_COUNTER, value)
        }
    var oneMinuteBeforeNotificationEnabled: Boolean
        get() = sharedPreferences.getBoolean(
            ENABLE_ONE_MINUTE_BEFORE_NOTIFICATION, false
        )
        set(value) = sharedPreferences.edit {
            putBoolean(ENABLE_ONE_MINUTE_BEFORE_NOTIFICATION, value)
        }


    var workDuration: Int
        get() = sharedPreferences.getInt(WORK_DURATION, 25) ?: 25
        set(value) = sharedPreferences.edit {
            putInt(WORK_DURATION, value)
        }

    var breakDuration: Int
        get() = sharedPreferences.getInt(BREAK_DURATION, 25) ?: 25
        set(value) = sharedPreferences.edit {
            putInt(BREAK_DURATION, value)
        }

    var longDuration: Int
        get() = sharedPreferences.getInt(BREAK_DURATION, 25) ?: 25
        set(value) = sharedPreferences.edit {
            putInt(LONG_BREAK_DURATION, value)
        }

    var currentSessionLabel: Label
        get() = Label(
            currentSessionLabelPref,
            currentSessionColorPref,
        )
        set(label) {
            currentSessionLabelPref = label.title
            currentSessionColorPref = label.colorId
        }
    var currentSessionColorPref: Int
        get() = sharedPreferences.getInt(CURRENT_SESSION_COLOR, 0)
        set(value) = sharedPreferences.edit {
            putInt(CURRENT_SESSION_COLOR, value)
        }

    var currentSessionLabelPref: String
        get() = sharedPreferences.getString(CURRENT_SESSION_LABEL, "") ?: ""
        set(value) = sharedPreferences.edit {
            putString(CURRENT_SESSION_LABEL, value)
        }

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
        PomodoroApplication.getContext()
    )

    fun registerOnSharedPreferenceChangedListener(
        listener: SharedPreferences.OnSharedPreferenceChangeListener,
    ) = sharedPreferences.registerOnSharedPreferenceChangeListener(listener)


    fun unregisterOnSharedPreferenceChangedListener(
        changeListener: SharedPreferences.OnSharedPreferenceChangeListener,
    ) = sharedPreferences.unregisterOnSharedPreferenceChangeListener(changeListener)

    var languageCode: String
        get() = sharedPreferences.getString(LANGUAGE_NAME, "auto") ?: "auto"
        set(value) = sharedPreferences.edit {
            putString(LANGUAGE_NAME, value)
        }

    var isFirstRun: Boolean
        get() = sharedPreferences.getBoolean(
            IS_FIRST_RUN, true
        )
        set(value) = sharedPreferences.edit {
            putBoolean(IS_FIRST_RUN, value)
        }

    val isFullScreenMode
        get() = sharedPreferences.getBoolean(
            TOGGLE_FULL_SCREEN, false
        )

    private val isBlackMode
        get() = sharedPreferences.getBoolean(
            BLACK_THEME, false
        )

    var isLocaleAutoStorageEnabled: Boolean
        get() = sharedPreferences.getBoolean(
            LOCALE_AUTO_STORE_ENABLED,
            false
        )
        set(value) = sharedPreferences.edit {
            putBoolean(LOCALE_AUTO_STORE_ENABLED, value)
        }

    val materialYou
        get() = sharedPreferences.getBoolean(MATERIAL_YOU, VersionUtils.hasS())

    fun getGeneralThemeValue(isSystemDark: Boolean): ThemeMode {
        val themeMode: String =
            sharedPreferences.getStringOrDefault(GENERAL_THEME, "auto")
        return if (isBlackMode && isSystemDark && themeMode != "light") {
            ThemeMode.BLACK
        } else {
            if (isBlackMode && themeMode == "dark") {
                ThemeMode.BLACK
            } else {
                when (themeMode) {
                    "light" -> ThemeMode.LIGHT
                    "dark" -> ThemeMode.DARK
                    "auto" -> ThemeMode.AUTO
                    else -> ThemeMode.AUTO
                }
            }
        }
    }

}