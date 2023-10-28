package com.ilhomsoliev.pomodoroapp.shared.icons.appicon

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val AppIcon: ImageVector
    get() {
        if (_appIcon != null) {
            return _appIcon!!
        }
        _appIcon = Builder(
            name = "AppIcon", defaultWidth = 160.0.dp, defaultHeight = 160.0.dp,
            viewportWidth = 160.0f, viewportHeight = 160.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF565656)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(160.0f)
                verticalLineToRelative(160.0f)
                horizontalLineToRelative(-160.0f)
                close()
            }
            path(
                fill = radialGradient(
                    0.0f to Color(0xE86200EE), 1.0f to Color(0x6B6200EE), center
                    = Offset(80.0f, 80.0f), radius = 80.0f
                ), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(80.0f, 80.0f)
                moveToRelative(-80.0f, 0.0f)
                arcToRelative(80.0f, 80.0f, 0.0f, true, true, 160.0f, 0.0f)
                arcToRelative(80.0f, 80.0f, 0.0f, true, true, -160.0f, 0.0f)
            }
        }
            .build()
        return _appIcon!!
    }

private var _appIcon: ImageVector? = null
