package com.ilhomsoliev.pomodoroapp.feature.timer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType
import com.ilhomsoliev.pomodoroapp.feature.timer.compose.AnimatedTimer

@Composable
fun TimerMain(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    overalltime: Int,
    duration: Int,
    isInActive: Boolean,
    sessionType: SessionType?,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AnimatedTimer(
            modifier = Modifier
                .clickable(
                    MutableInteractionSource(), indication = null, onClick = {
                        onClick()

                    }
                ),
            timeOverall = overalltime,
            currentTime = duration,
            isInactive = isInActive,
            sessionType = sessionType,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(26.dp),
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "status: ${sessionType?.name}",
                style = TextStyle(
                    fontSize = 25.sp,
                    lineHeight = 25.98.sp,
                    // fontFamily = FontFamily(Font(R.font.dm sans)),
                    fontWeight = FontWeight(700),
                    color = Color(0xE86200EE),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }

}