package com.ilhomsoliev.appthemehelper.common

import androidx.appcompat.widget.Toolbar

class ATHActionBarActivity : ATHToolbarActivity() {

    override fun getATHToolbar(): Toolbar? {
        return com.ilhomsoliev.appthemehelper.util.ToolbarContentTintHelper.getSupportActionBarView(supportActionBar)
    }
}
