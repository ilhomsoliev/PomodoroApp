package com.ilhomsoliev.pomodoroapp.core.extentions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil

fun AppCompatActivity.hideStatusBar() {
    hideStatusBar(PreferenceUtil.isFullScreenMode)
}

private fun AppCompatActivity.hideStatusBar(fullscreen: Boolean) {
    // TODO
    /*val statusBar = window.decorView.rootView.findViewById<View>(R.id.status_bar)
    if (statusBar != null) {
        statusBar.isGone = fullscreen
    }*/
}