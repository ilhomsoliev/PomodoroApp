package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.extentions.printToLog

@Composable
fun CustomSliderItem(
    title: String,
    maxValue: Int = 240,
    currentValue: Int = 25,
    onSliderPositionChange: (Int) -> Unit
) {
    var sliderPosition by remember { mutableFloatStateOf(currentValue.toFloat()) }

    val sliderDer = remember {
        derivedStateOf { sliderPosition }
    }

    LaunchedEffect(key1 = sliderDer.value, block = {
        sliderDer.printToLog()
        onSliderPositionChange((sliderDer.value).toInt())
    })

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(R.font.dm_sans)),
                fontWeight = FontWeight(500),
                color = Color(0xD1000000),
            )
        )
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.weight(1f),
            ) {
                Slider(
                    steps = 1,
                    valueRange = 1f..maxValue.toFloat(),
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it }
                )
            }
            /*Slider(
                modifier = Modifier.weight(1f),
                value = sliderPosition, //currentValue.toFloat() / maxValue.toFloat(),
                onValueChange = {
                    sliderPosition = it
                    it.printToLog()
                     // onSliderPositionChange((it * maxValue).toInt())
                },
                *//*colors = SliderDefaults.colors(
                    thumbColor = Color.Purple,
                    activeTrackColor = Color.Purple,
                    inactiveTrackColor = Color.Gray
                ),*//*
            )*/
            Text(
                text = currentValue.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.dm_sans)),
                    fontWeight = FontWeight(500),
                    color = Color(0xD1000000),
                    textAlign = TextAlign.Right,
                )
            )
        }
    }


}