package com.ilhomsoliev.pomodoroapp.feature.timer.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5EEFF))
                .clickable {
                    onClick()
                }, contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color(0xFFA478E4))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                // fontFamily = FontFamily(Font(R.font.dm sans)),
                fontWeight = FontWeight(500),
                color = Color(0x8A000000),
            )
        )

    }

}