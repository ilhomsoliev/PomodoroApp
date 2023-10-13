package com.ilhomsoliev.pomodoroapp.shared.util

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import kotlin.math.abs

abstract class OnSwipeTouchListener(context: Context?) : OnTouchListener {

    private val gestureDetector: GestureDetector
    private lateinit var view: View

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        this.view = view
        if (event.action == MotionEvent.ACTION_DOWN) {
            onPress(view)
        } else if (event.action == MotionEvent.ACTION_UP) {
            onRelease(view)
        }
        return gestureDetector.onTouchEvent(event)
    }

    protected abstract fun onSwipeRight(view: View)
    protected abstract fun onSwipeLeft(view: View)
    protected abstract fun onSwipeBottom(view: View)
    protected abstract fun onSwipeTop(view: View)
    protected abstract fun onClick(view: View)
    protected abstract fun onLongClick(view: View)
    protected abstract fun onPress(view: View)
    protected abstract fun onRelease(view: View)
    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            onLongClick(view)
            super.onLongPress(e)
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            onClick(view)
            return super.onSingleTapUp(e)
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false
            try {
                val diffY = e2.y - e1?.y!! // TODO
                val diffX = e2.x - e1?.x!!
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight(view)
                        } else {
                            onSwipeLeft(view)
                        }
                        result = true
                    }
                } else if (abs(diffY) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom(view)
                    } else {
                        onSwipeTop(view)
                    }
                    result = true
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }
    }

    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }
}