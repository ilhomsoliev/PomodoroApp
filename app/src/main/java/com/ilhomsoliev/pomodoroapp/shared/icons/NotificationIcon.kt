package com.ilhomsoliev.pomodoroapp.shared.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val NotificationIcon: ImageVector
    get() {
        if (_notificationIcon != null) {
            return _notificationIcon!!
        }
        _notificationIcon = Builder(
            name = "NotificationIcon", defaultWidth = 24.0.dp, defaultHeight
            = 24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 0.82f, strokeLineWidth = 2.0f, strokeLineCap = Round,
                strokeLineJoin = StrokeJoin.Companion.Round, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(10.0f, 22.0f)
                horizontalLineTo(14.0f)
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 0.82f, strokeLineWidth = 2.0f, strokeLineCap = Round,
                strokeLineJoin = StrokeJoin.Companion.Round, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(5.269f, 10.7499f)
                curveTo(5.2678f, 9.8604f, 5.4426f, 8.9795f, 5.7834f, 8.1579f)
                curveTo(6.1242f, 7.3363f, 6.6243f, 6.5903f, 7.2548f, 5.9628f)
                curveTo(7.8853f, 5.3354f, 8.6337f, 4.8389f, 9.4569f, 4.502f)
                curveTo(10.2802f, 4.1652f, 11.1619f, 3.9946f, 12.0514f, 4.0001f)
                curveTo(15.7629f, 4.0277f, 18.7317f, 7.1128f, 18.7317f, 10.8347f)
                verticalLineTo(11.4999f)
                curveTo(18.7317f, 14.8577f, 19.0f, 17.0f, 20.0529f, 17.871f)
                curveTo(20.1196f, 17.9848f, 20.1551f, 18.1142f, 20.1558f, 18.246f)
                curveTo(20.1565f, 18.3779f, 20.1224f, 18.5076f, 20.0569f, 18.6221f)
                curveTo(19.9915f, 18.7366f, 19.8971f, 18.8318f, 19.7831f, 18.8982f)
                curveTo(19.6691f, 18.9645f, 19.5397f, 18.9996f, 19.4078f, 18.9999f)
                horizontalLineTo(4.5922f)
                curveTo(4.4603f, 18.9996f, 4.3309f, 18.9645f, 4.2169f, 18.8981f)
                curveTo(4.1029f, 18.8318f, 4.0084f, 18.7366f, 3.943f, 18.622f)
                curveTo(3.8776f, 18.5075f, 3.8435f, 18.3778f, 3.8442f, 18.2459f)
                curveTo(3.845f, 18.114f, 3.8805f, 17.9846f, 3.9472f, 17.8709f)
                curveTo(5.0f, 17.0f, 5.269f, 14.8575f, 5.269f, 11.4999f)
                lineTo(5.269f, 10.7499f)
                close()
            }
        }
            .build()
        return _notificationIcon!!
    }

private var _notificationIcon: ImageVector? = null
