package com.ilhomsoliev.pomodoroapp.core.util.theme

import android.content.Context
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.generalThemeValue

@StyleRes
fun Context.getThemeResValue(): Int =
    R.style.AppTheme
// TODO
/*if (PreferenceUtil.materialYou) {
    if (generalThemeValue == ThemeMode.BLACK)
        R.style.Theme_RetroMusic_MD3_Black
    else R.style.Theme_RetroMusic_MD3
} else {
    when (generalThemeValue) {
        ThemeMode.LIGHT -> R.style.Theme_RetroMusic_Light
        ThemeMode.DARK -> R.style.Theme_RetroMusic_Base
        ThemeMode.BLACK -> R.style.Theme_RetroMusic_Black
        ThemeMode.AUTO -> R.style.Theme_RetroMusic_FollowSystem
    }
}*/

fun Context.getNightMode(): Int = when (generalThemeValue) {
    ThemeMode.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
    ThemeMode.DARK -> AppCompatDelegate.MODE_NIGHT_YES
    else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
}