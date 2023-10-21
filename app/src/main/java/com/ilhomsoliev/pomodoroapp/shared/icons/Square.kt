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

public val Square: ImageVector
    get() {
        if (_square != null) {
            return _square!!
        }
        _square = Builder(
            name = "Square", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFA478E4)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(16.0f, 4.0f)
                horizontalLineTo(8.0f)
                curveTo(5.7909f, 4.0f, 4.0f, 5.7909f, 4.0f, 8.0f)
                verticalLineTo(16.0f)
                curveTo(4.0f, 18.2091f, 5.7909f, 20.0f, 8.0f, 20.0f)
                horizontalLineTo(16.0f)
                curveTo(18.2091f, 20.0f, 20.0f, 18.2091f, 20.0f, 16.0f)
                verticalLineTo(8.0f)
                curveTo(20.0f, 5.7909f, 18.2091f, 4.0f, 16.0f, 4.0f)
                close()
            }
        }
            .build()
        return _square!!
    }

private var _square: ImageVector? = null
