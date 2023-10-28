package com.ilhomsoliev.pomodoroapp.shared.dialogs.alertDialogs

import androidx.compose.runtime.Composable
import com.ilhomsoliev.pomodoroapp.shared.dialogs.alertDialogs.BaseAlertDialog

@Composable
fun DeleteChatDialog(
    isDialogShown: Boolean,
    onDismissRequest: () -> Unit,
    onNegativeButtonClick: () -> Unit = onDismissRequest,
    onPositiveButtonClick: (Boolean) -> Unit,
) {
    BaseAlertDialog(
        isDialogShown = isDialogShown,
        onDismissRequest = onDismissRequest,
        title = "Удалить чат",
        description = "Уверены что хотите удалить чат?",
        negativeButtonText = "ОТМЕНА",
        positiveButtonText = "УДАЛИТЬ",
        isCheckBoxActive = false,
        checkBoxText = "Удалить только у себя",
        onNegativeButtonClick = {
            onNegativeButtonClick()
        },
        onPositiveButtonClick = {
            onPositiveButtonClick(it ?: false)
        },
    )

}