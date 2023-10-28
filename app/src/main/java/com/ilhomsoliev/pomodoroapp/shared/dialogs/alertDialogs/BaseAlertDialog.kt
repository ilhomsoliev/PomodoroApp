package com.ilhomsoliev.pomodoroapp.shared.dialogs.alertDialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseAlertDialog(
    modifier: Modifier = Modifier,
    isDialogShown: Boolean,
    onDismissRequest: () -> Unit,
    isCheckBoxActive: (Boolean)? = null,
    checkBoxText: String? = null,
    title: String? = null,
    description: String? = null,
    positiveButtonText: String? = null,
    negativeButtonText: String? = null,
    onPositiveButtonClick: ((Boolean?) -> Unit)? = null,
    onNegativeButtonClick: (() -> Unit)? = null,
    extra: (@Composable ColumnScope.() -> Unit)?=null,
) {
    var isCheckBoxActiveState by remember { mutableStateOf(isCheckBoxActive) }

    if (isDialogShown)
        AlertDialog(
            modifier = modifier,
            shape = RoundedCornerShape(4.dp),
            onDismissRequest = { onDismissRequest() },
            title = {
                title?.let {
                    Text(text = title)
                }
            },
            text = {
                Column {
                    description?.let {
                        Text(text = it)
                    }
                    checkBoxText?.let { text ->
                        isCheckBoxActiveState?.let {
                            Row(
                                modifier = Modifier.offset((-8).dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(checked = it, onCheckedChange = {
                                    isCheckBoxActiveState = it
                                })
                                Text(text = text, modifier = Modifier.clickable {
                                    isCheckBoxActiveState = !it
                                })
                            }
                        }
                    }
                    extra?.let{
                        this.it()
                    }
                }
            },
            dismissButton = {
                negativeButtonText?.let {
                    TextButton(onClick = {
                        onNegativeButtonClick?.let { it() }
                    }) {
                        Text(text = it)
                    }
                }
            },
            confirmButton = {
                positiveButtonText?.let {
                    TextButton(onClick = {
                        onPositiveButtonClick?.let { it(isCheckBoxActiveState) }
                    }) {
                        Text(text = it)
                    }
                }
            })
}