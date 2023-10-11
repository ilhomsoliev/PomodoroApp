package com.ilhomsoliev.appthemehelper

import android.content.Context
import android.view.View
import androidx.annotation.ColorInt
import com.ilhomsoliev.appthemehelper.util.TintHelper

object ATH {

    fun didThemeValuesChange(context: Context, since: Long): Boolean {
        return com.ilhomsoliev.appthemehelper.ThemeStore.Companion.isConfigured(context) && com.ilhomsoliev.appthemehelper.ThemeStore.Companion.prefs(
            context
        ).getLong(
            com.ilhomsoliev.appthemehelper.ThemeStorePrefKeys.Companion.VALUES_CHANGED,
            -1
        ) > since
    }

    fun setTint(view: View, @ColorInt color: Int) {
        TintHelper.setTintAuto(view, color, false)
    }

    fun setBackgroundTint(view: View, @ColorInt color: Int) {
        TintHelper.setTintAuto(view, color, true)
    }
}