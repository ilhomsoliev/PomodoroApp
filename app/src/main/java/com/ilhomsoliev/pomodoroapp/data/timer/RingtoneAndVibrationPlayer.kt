package com.ilhomsoliev.pomodoroapp.data.timer

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Context.VIBRATOR_SERVICE
import android.media.AudioAttributes.*
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Vibrator
import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.core.toRingtone
import com.ilhomsoliev.pomodoroapp.shared.util.VibrationPatterns
import java.io.IOException

class RingtoneAndVibrationPlayer constructor(
    val context: Context,
    val preferenceHelper: PreferenceUtil
) {
    private var mediaPlayer: MediaPlayer? = null
    private var vibrator: Vibrator? = null
    private val audioManager: AudioManager =
        context.getSystemService(AUDIO_SERVICE) as AudioManager

    fun play(sessionType: SessionType, insistent: Boolean) {
        try {
            vibrator = context.getSystemService(VIBRATOR_SERVICE) as Vibrator
            if (preferenceHelper.isRingtoneEnabled) {
                val ringtoneRaw =
                    if (sessionType == SessionType.WORK) preferenceHelper.getNotificationSoundWorkFinished
                    else preferenceHelper.getNotificationSoundBreakFinished

                val uri = Uri.parse(toRingtone(ringtoneRaw).uri)

                mediaPlayer = MediaPlayer()
                mediaPlayer!!.setDataSource(context, uri)
                audioManager.mode = AudioManager.MODE_NORMAL
                val attributes = Builder()
                    .setUsage(if (preferenceHelper.isPriorityAlarm) USAGE_ALARM else USAGE_NOTIFICATION)
                    .build()
                mediaPlayer!!.setAudioAttributes(attributes)
                mediaPlayer!!.isLooping = insistent
                mediaPlayer!!.prepareAsync()
                mediaPlayer!!.setOnPreparedListener {
                    // TODO: check duration of custom ringtones which may be much longer than notification sounds.
                    // If it's n seconds long and we're in continuous mode,
                    // schedule a stop after x seconds.
                    mediaPlayer!!.start()
                }
            }
            val vibrationType = preferenceHelper.getVibrationType.toInt()
            if (vibrationType > 0) {
                vibrator!!.vibrate(
                    VibrationPatterns.LIST[vibrationType],
                    if (insistent) 2 else -1
                )
            }
        } catch (e: SecurityException) {
            stop()
        } catch (e: IOException) {
            stop()
        }
    }

    fun stop() {
        if (mediaPlayer != null && vibrator != null) {
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
        if (vibrator != null) {
            vibrator!!.cancel()
        }
    }

}