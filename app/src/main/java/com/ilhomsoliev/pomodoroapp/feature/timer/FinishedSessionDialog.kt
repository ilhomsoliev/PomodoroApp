package com.ilhomsoliev.pomodoroapp.feature.timer

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.data.timer.SessionType
import com.ilhomsoliev.pomodoroapp.feature.BaseViewModel

class FinishedSessionDialog : DialogFragment() {
    interface Listener {
        fun onFinishedSessionDialogPositiveButtonClick(sessionType: SessionType)
        fun onFinishedSessionDialogNeutralButtonClick(sessionType: SessionType)
    }

    private var listener: Listener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            activity as Listener?
        } catch (e: ClassCastException) {
            throw ClassCastException("hosting activity must implement FinishedSessionDialog::Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false
        val builder = AlertDialog.Builder(requireContext())
        val viewModel: BaseViewModel by activityViewModels()
        val sessionType = viewModel.dialogPendingType
        if (sessionType === SessionType.WORK) {
            builder.setTitle(R.string.action_finished_session)
                .setPositiveButton(R.string.action_start_break) { _, _ ->
                    listener!!.onFinishedSessionDialogPositiveButtonClick(
                        sessionType
                    )
                }
                .setNeutralButton(R.string.dialog_close) { _, _ ->
                    listener!!.onFinishedSessionDialogNeutralButtonClick(
                        sessionType
                    )
                }
        } else {
            builder.setTitle(R.string.action_finished_break)
                .setPositiveButton(R.string.action_start_work) { _, _ ->
                    listener!!.onFinishedSessionDialogPositiveButtonClick(
                        sessionType
                    )
                }
                .setNeutralButton(android.R.string.cancel) { _, _ ->
                    listener!!.onFinishedSessionDialogNeutralButtonClick(
                        sessionType
                    )
                }
        }
        val d: Dialog = builder
            .setCancelable(false)
            .create()
        d.setCanceledOnTouchOutside(false)
        return d
    }

    companion object {
        fun newInstance(listener: Listener?): FinishedSessionDialog {
            val dialog = FinishedSessionDialog()
            dialog.listener = listener
            return dialog
        }
    }
}