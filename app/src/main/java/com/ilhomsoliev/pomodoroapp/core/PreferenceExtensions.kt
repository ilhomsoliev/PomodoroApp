package com.ilhomsoliev.pomodoroapp.core

import android.content.SharedPreferences

fun SharedPreferences.getStringOrDefault(key: String, default: String): String {
    return getString(key, default) ?: default
}
