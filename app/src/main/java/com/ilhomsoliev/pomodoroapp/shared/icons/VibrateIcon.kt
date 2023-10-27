package com.ilhomsoliev.pomodoroapp.shared.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val VibrateIcon: ImageVector
    get() {
        if (_vibrateIcon != null) {
            return _vibrateIcon!!
        }
        _vibrateIcon = Builder(
            name = "VibrateIcon", defaultWidth = 24.0.dp, defaultHeight =
            24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.82f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero
                ) {
                    moveTo(0.0f, 15.0f)
                    verticalLineTo(9.0f)
                    horizontalLineTo(2.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(0.0f)
                    close()
                    moveTo(3.0f, 17.0f)
                    verticalLineTo(7.0f)
                    horizontalLineTo(5.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(3.0f)
                    close()
                    moveTo(22.0f, 15.0f)
                    verticalLineTo(9.0f)
                    horizontalLineTo(24.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(22.0f)
                    close()
                    moveTo(19.0f, 17.0f)
                    verticalLineTo(7.0f)
                    horizontalLineTo(21.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(19.0f)
                    close()
                    moveTo(8.0f, 21.0f)
                    curveTo(7.45f, 21.0f, 6.9792f, 20.8042f, 6.5875f, 20.4125f)
                    curveTo(6.1958f, 20.0208f, 6.0f, 19.55f, 6.0f, 19.0f)
                    verticalLineTo(5.0f)
                    curveTo(6.0f, 4.45f, 6.1958f, 3.9792f, 6.5875f, 3.5875f)
                    curveTo(6.9792f, 3.1958f, 7.45f, 3.0f, 8.0f, 3.0f)
                    horizontalLineTo(16.0f)
                    curveTo(16.55f, 3.0f, 17.0208f, 3.1958f, 17.4125f, 3.5875f)
                    curveTo(17.8042f, 3.9792f, 18.0f, 4.45f, 18.0f, 5.0f)
                    verticalLineTo(19.0f)
                    curveTo(18.0f, 19.55f, 17.8042f, 20.0208f, 17.4125f, 20.4125f)
                    curveTo(17.0208f, 20.8042f, 16.55f, 21.0f, 16.0f, 21.0f)
                    horizontalLineTo(8.0f)
                    close()
                    moveTo(8.0f, 19.0f)
                    horizontalLineTo(16.0f)
                    verticalLineTo(5.0f)
                    horizontalLineTo(8.0f)
                    verticalLineTo(19.0f)
                    close()
                }
            }
        }
            .build()
        return _vibrateIcon!!
    }

private var _vibrateIcon: ImageVector? = null
