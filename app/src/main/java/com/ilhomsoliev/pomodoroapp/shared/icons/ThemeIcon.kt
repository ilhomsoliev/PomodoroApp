package com.ilhomsoliev.pomodoroapp.shared.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ThemeIcon: ImageVector
    get() {
        if (_themeIcon != null) {
            return _themeIcon!!
        }
        _themeIcon = Builder(
            name = "ThemeIcon", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.82f,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(12.0f, 21.0f)
                curveTo(9.5f, 21.0f, 7.375f, 20.125f, 5.625f, 18.375f)
                curveTo(3.875f, 16.625f, 3.0f, 14.5f, 3.0f, 12.0f)
                curveTo(3.0f, 9.5f, 3.875f, 7.375f, 5.625f, 5.625f)
                curveTo(7.375f, 3.875f, 9.5f, 3.0f, 12.0f, 3.0f)
                curveTo(12.2333f, 3.0f, 12.4625f, 3.0083f, 12.6875f, 3.025f)
                curveTo(12.9125f, 3.0417f, 13.1333f, 3.0667f, 13.35f, 3.1f)
                curveTo(12.6667f, 3.5833f, 12.1208f, 4.2125f, 11.7125f, 4.9875f)
                curveTo(11.3042f, 5.7625f, 11.1f, 6.6f, 11.1f, 7.5f)
                curveTo(11.1f, 9.0f, 11.625f, 10.275f, 12.675f, 11.325f)
                curveTo(13.725f, 12.375f, 15.0f, 12.9f, 16.5f, 12.9f)
                curveTo(17.4167f, 12.9f, 18.2583f, 12.6958f, 19.025f, 12.2875f)
                curveTo(19.7917f, 11.8792f, 20.4167f, 11.3333f, 20.9f, 10.65f)
                curveTo(20.9333f, 10.8667f, 20.9583f, 11.0875f, 20.975f, 11.3125f)
                curveTo(20.9917f, 11.5375f, 21.0f, 11.7667f, 21.0f, 12.0f)
                curveTo(21.0f, 14.5f, 20.125f, 16.625f, 18.375f, 18.375f)
                curveTo(16.625f, 20.125f, 14.5f, 21.0f, 12.0f, 21.0f)
                close()
                moveTo(12.0f, 19.0f)
                curveTo(13.4667f, 19.0f, 14.7833f, 18.5958f, 15.95f, 17.7875f)
                curveTo(17.1167f, 16.9792f, 17.9667f, 15.925f, 18.5f, 14.625f)
                curveTo(18.1667f, 14.7083f, 17.8333f, 14.775f, 17.5f, 14.825f)
                curveTo(17.1667f, 14.875f, 16.8333f, 14.9f, 16.5f, 14.9f)
                curveTo(14.45f, 14.9f, 12.7042f, 14.1792f, 11.2625f, 12.7375f)
                curveTo(9.8208f, 11.2958f, 9.1f, 9.55f, 9.1f, 7.5f)
                curveTo(9.1f, 7.1667f, 9.125f, 6.8333f, 9.175f, 6.5f)
                curveTo(9.225f, 6.1667f, 9.2917f, 5.8333f, 9.375f, 5.5f)
                curveTo(8.075f, 6.0333f, 7.0208f, 6.8833f, 6.2125f, 8.05f)
                curveTo(5.4042f, 9.2167f, 5.0f, 10.5333f, 5.0f, 12.0f)
                curveTo(5.0f, 13.9333f, 5.6833f, 15.5833f, 7.05f, 16.95f)
                curveTo(8.4167f, 18.3167f, 10.0667f, 19.0f, 12.0f, 19.0f)
                close()
            }
        }
            .build()
        return _themeIcon!!
    }

private var _themeIcon: ImageVector? = null
