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

public val TimeIcon: ImageVector
    get() {
        if (_timeIcon != null) {
            return _timeIcon!!
        }
        _timeIcon = Builder(
            name = "TimeIcon", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.82f, strokeAlpha
                = 0.82f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(8.0f, 20.0f)
                horizontalLineTo(16.0f)
                verticalLineTo(17.0f)
                curveTo(16.0f, 15.9f, 15.6083f, 14.9583f, 14.825f, 14.175f)
                curveTo(14.0417f, 13.3917f, 13.1f, 13.0f, 12.0f, 13.0f)
                curveTo(10.9f, 13.0f, 9.9583f, 13.3917f, 9.175f, 14.175f)
                curveTo(8.3917f, 14.9583f, 8.0f, 15.9f, 8.0f, 17.0f)
                verticalLineTo(20.0f)
                close()
                moveTo(4.0f, 22.0f)
                verticalLineTo(20.0f)
                horizontalLineTo(6.0f)
                verticalLineTo(17.0f)
                curveTo(6.0f, 15.9833f, 6.2375f, 15.0292f, 6.7125f, 14.1375f)
                curveTo(7.1875f, 13.2458f, 7.85f, 12.5333f, 8.7f, 12.0f)
                curveTo(7.85f, 11.4667f, 7.1875f, 10.7542f, 6.7125f, 9.8625f)
                curveTo(6.2375f, 8.9708f, 6.0f, 8.0167f, 6.0f, 7.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(4.0f)
                verticalLineTo(2.0f)
                horizontalLineTo(20.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(18.0f)
                verticalLineTo(7.0f)
                curveTo(18.0f, 8.0167f, 17.7625f, 8.9708f, 17.2875f, 9.8625f)
                curveTo(16.8125f, 10.7542f, 16.15f, 11.4667f, 15.3f, 12.0f)
                curveTo(16.15f, 12.5333f, 16.8125f, 13.2458f, 17.2875f, 14.1375f)
                curveTo(17.7625f, 15.0292f, 18.0f, 15.9833f, 18.0f, 17.0f)
                verticalLineTo(20.0f)
                horizontalLineTo(20.0f)
                verticalLineTo(22.0f)
                horizontalLineTo(4.0f)
                close()
            }
        }
            .build()
        return _timeIcon!!
    }

private var _timeIcon: ImageVector? = null
