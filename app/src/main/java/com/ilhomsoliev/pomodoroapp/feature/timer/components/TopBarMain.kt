package com.ilhomsoliev.pomodoroapp.feature.timer.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.findNavController
import com.ilhomsoliev.pomodoroapp.R

@Composable
fun TopBarMain(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "TimerClick",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    // fontFamily = FontFamily(Font(R.font.dm sans)),
                    fontWeight = FontWeight(700),
                    color = Color(0xD1000000),
                    textAlign = TextAlign.Center,
                )
            )
            IconButton(onClick = {
                onSettingsClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        }
        Divider()
    }

}