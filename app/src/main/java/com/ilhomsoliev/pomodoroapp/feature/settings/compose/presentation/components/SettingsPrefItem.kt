package com.ilhomsoliev.pomodoroapp.feature.settings.compose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.pomodoroapp.R

@Composable
fun SettingsPrefItem(
    icon: ImageVector? = null,
    title: String,
    description: String? = null,
    isToggleActive: Boolean? = null,
    onToggleClick: (Boolean) -> Unit = {},
    onClick: () -> Unit = {},
    isCheckboxActive: Boolean? = null,
    onCheckboxClick: (Boolean) -> Unit = {},
    hasDivider: Boolean = true,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                icon?.let {
                    Image(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .size(24.dp),
                        imageVector = icon,
                        contentDescription = null
                    )
                }

                Column(modifier = Modifier.padding(start = 16.dp)) {
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
                    description?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.dm_sans)),
                                fontWeight = FontWeight(500),
                                color = Color(0x8F000000),
                            )
                        )
                    }
                }
            }
            isToggleActive?.let {
                Switch(checked = it, onCheckedChange = { value ->
                    onToggleClick(value)
                })
            }
            isCheckboxActive?.let {
                Checkbox(checked = it, onCheckedChange = { value ->
                    onCheckboxClick(value)
                })
            }
        }
        if (hasDivider)
            Divider(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(start = 72.dp)
            )
    }
}