package com.ilhomsoliev.pomodoroapp.core.extentions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat

fun String.copyToClipboard(context: Context) {
    val clipboardManager = ContextCompat.getSystemService(context, ClipboardManager::class.java)
    val clip = ClipData.newPlainText("clipboard", this)
    clipboardManager?.setPrimaryClip(clip)
}

fun Any?.printToLog(tag: String = "DEBUG_LOG") {
    Log.d(tag, toString())
}

fun Boolean?.toStringCustom() = if (this == true) "1" else if (this == false) "0" else ""

fun isEmailValid(email: String): Boolean {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}".toRegex()
    return emailPattern.matches(email)
}