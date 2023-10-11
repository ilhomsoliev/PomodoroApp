package com.ilhomsoliev.pomodoroapp.core.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File


object Share {
    fun shareStoryToSocial(context: Context, uri: Uri) {
        val feedIntent = Intent(Intent.ACTION_SEND)
        feedIntent.type = "image/*"
        feedIntent.putExtra(Intent.EXTRA_STREAM, uri)
        context.startActivity(feedIntent, null)
    }

    fun shareFile(context: Context, file: File, mimeType: String) {
        Intent(Intent.ACTION_SEND).apply {
            type = mimeType
            putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(
                context,
                context.applicationContext.packageName,
                file
            ))
            context.startActivity(Intent.createChooser(this, null))
        }
    }
}