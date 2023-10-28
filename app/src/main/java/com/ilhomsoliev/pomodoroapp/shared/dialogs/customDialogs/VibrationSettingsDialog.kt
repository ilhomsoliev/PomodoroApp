package com.ilhomsoliev.pomodoroapp.shared.dialogs.customDialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.ilhomsoliev.pomodoroapp.shared.model.VibrationTypeEnum
import com.ilhomsoliev.pomodoroapp.shared.radio_button.CustomRadioButton

@Composable
fun VibrationSettingsDialog(
    isDialogShown: Boolean,
    vibrationType: VibrationTypeEnum,
    onDismissRequest: () -> Unit,
    onNegativeButtonClick: () -> Unit = onDismissRequest,
    onPositiveButtonClick: (VibrationTypeEnum) -> Unit,
) {

    val picked = remember { mutableStateOf(vibrationType) }

    BaseCustomDialog(
        isDialogShown = isDialogShown,
        onDismissRequest = onDismissRequest,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Vibrstion",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.dm_sans)),
                    fontWeight = FontWeight(700),
                    color = Color(0xD1000000),
                    textAlign = TextAlign.Center,
                )
            )
            VibrationTypeEnum.entries.forEach {
                CustomRadioButton(picked.value == it, it.name, onClick = {
                    picked.value = it
                })
            }
            Row(
                modifier = Modifier.align(Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionDialogText("CANCEL", onClick = {
                    onNegativeButtonClick()
                })

                Spacer(modifier = Modifier.width(16.dp))

                ActionDialogText("OK", onClick = {
                    onPositiveButtonClick(picked.value)
                })
            }
        }
    }
}

@Composable
fun ActionDialogText(
    text: String,
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier.clickable {
            onClick()
        },
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Font(R.font.dm_sans)),
            fontWeight = FontWeight(500),
            color = Color(0xFF6200EE),
            textAlign = TextAlign.Center,
            letterSpacing = 1.25.sp,
        )
    )

}