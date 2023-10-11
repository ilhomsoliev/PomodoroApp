package com.ilhomsoliev.appthemehelper.common.views

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.isVisible
import com.google.android.material.materialswitch.MaterialSwitch
import com.ilhomsoliev.appthemehelper.ThemeStore

/**
 * @author Aidan Follestad (afollestad)
 */
class ATESwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1,
) : MaterialSwitch(context, attrs, defStyleAttr) {

    init {
        if (!isInEditMode && !ThemeStore.isMD3Enabled(context)) {
            com.ilhomsoliev.appthemehelper.ATH.setTint(this, ThemeStore.accentColor(context))
        }
    }

    override fun isShown(): Boolean {
        return parent != null && isVisible
    }
}