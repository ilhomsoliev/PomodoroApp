package com.ilhomsoliev.pomodoroapp.core

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.ilhomsoliev.appthemehelper.util.VersionUtils
import com.ilhomsoliev.pomodoroapp.app.PomodoroApplication
import com.ilhomsoliev.pomodoroapp.core.util.theme.ThemeMode

object PreferenceUtil {
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