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

public val Pause: ImageVector
    get() {
        if (_pause != null) {
            return _pause!!
        }
        _pause = Builder(name = "Pause", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFA478E4)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.0f, 20.0f)
                horizontalLineTo(6.0f)
                curveTo(5.7348f, 20.0f, 5.4804f, 19.9234f, 5.2929f, 19.787f)
                curveTo(5.1054f, 19.6506f, 5.0f, 19.4656f, 5.0f, 19.2727f)
                verticalLineTo(4.7273f)
                curveTo(5.0f, 4.5344f, 5.1054f, 4.3494f, 5.2929f, 4.213f)
                curveTo(5.4804f, 4.0766f, 5.7348f, 4.0f, 6.0f, 4.0f)
                horizontalLineTo(9.0f)
                curveTo(9.2652f, 4.0f, 9.5196f, 4.0766f, 9.7071f, 4.213f)
                curveTo(9.8946f, 4.3494f, 10.0f, 4.5344f, 10.0f, 4.7273f)
                verticalLineTo(19.2727f)
                curveTo(10.0f, 19.4656f, 9.8946f, 19.6506f, 9.7071f, 19.787f)
                curveTo(9.5196f, 19.9234f, 9.2652f, 20.0f, 9.0f, 20.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA478E4)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.0f, 20.0f)
                horizontalLineTo(15.0f)
                curveTo(14.7348f, 20.0f, 14.4804f, 19.9234f, 14.2929f, 19.787f)
                curveTo(14.1054f, 19.6506f, 14.0f, 19.4656f, 14.0f, 19.2727f)
                verticalLineTo(4.7273f)
                curveTo(14.0f, 4.5344f, 14.1054f, 4.3494f, 14.2929f, 4.213f)
                curveTo(14.4804f, 4.0766f, 14.7348f, 4.0f, 15.0f, 4.0f)
                horizontalLineTo(18.0f)
                curveTo(18.2652f, 4.0f, 18.5196f, 4.0766f, 18.7071f, 4.213f)
                curveTo(18.8946f, 4.3494f, 19.0f, 4.5344f, 19.0f, 4.7273f)
                verticalLineTo(19.2727f)
                curveTo(19.0f, 19.4656f, 18.8946f, 19.6506f, 18.7071f, 19.787f)
                curveTo(18.5196f, 19.9234f, 18.2652f, 20.0f, 18.0f, 20.0f)
                close()
            }
        }
        .build()
        return _pause!!
    }

private var _pause: ImageVector? = null
