package com.ilhomsoliev.pomodoroapp.feature.timer.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ilhomsoliev.pomodoroapp.data.timer.TimerState
import com.ilhomsoliev.pomodoroapp.feature.timer.compose.ControlButton
import com.ilhomsoliev.pomodoroapp.feature.timer.compose.StartButton
import com.ilhomsoliev.pomodoroapp.shared.icons.Pause
import com.ilhomsoliev.pomodoroapp.shared.icons.Square

@Composable
fun ButtonTimerMain(
    modifier: Modifier = Modifier,
    timerState: TimerState?,
    onStartButtonClick: () -> Unit,
    onSkipButtonClick: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        AnimatedContent(targetState = timerState == TimerState.INACTIVE, label = "") {
            if (it) {
                StartButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    onStartButtonClick()
                }

            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ControlButton(
                        if (TimerState.ACTIVE == timerState) Pause else Icons.Default.PlayArrow,
                        "Pause"
                    ) {
                        onStartButtonClick()
                    }
                    ControlButton(Square, "Quit") {
                        onSkipButtonClick()
                    }
                }
            }

        }
    }
}