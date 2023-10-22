package com.ilhomsoliev.pomodoroapp.feature.timer.compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AnimatedTimer(
    modifier: Modifier = Modifier,
    timeOverall: Int,
    currentTime: Int,
    isInactive: Boolean,
) {
    val strokeWidth = 24.dp;
    val progress by animateFloatAsState(
        targetValue = 360f * (currentTime.toFloat() / timeOverall.toFloat()), label = ""
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background Circle
        Canvas(modifier = Modifier.size(200.dp)) {
            drawCircle(
                color = Color(0xFFF5EEFF),
                style = Stroke(width = strokeWidth.toPx())
            )
        }

        // Animated Progress Circle
        Canvas(modifier = Modifier.size(200.dp)) {
            drawArc(
                color = Color(0xFF6200EE), // #FFFFFF, #6200EE
                startAngle = -90f, // Start at the top
                sweepAngle = 360f - progress,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round),
            )

        }

        // Timer Text
        Text(
            text = if (isInactive) "Click\nstart" else getTimeDisplayed(currentTime),
            style = TextStyle(
                fontSize = 38.sp,
                lineHeight = 38.sp,
                // fontFamily = FontFamily(Font(R.font.dm sans)),
                fontWeight = FontWeight(700),
                color = Color(0xD1000000),
                textAlign = TextAlign.Center,
            )
        )
    }
}

fun getTimeDisplayed(currentTime: Int): String {
    val m = currentTime / 60
    val s = currentTime % 60
    var ans = ""
    if (m < 10) ans += "0"
    ans += "$m:"
    if (s < 10) ans += "0"
    ans += "$s"
    return ans
}
