package com.ilhomsoliev.pomodoroapp.feature.timer

import com.ilhomsoliev.pomodoroapp.databinding.FragmentTimerBinding

class TimerBinding(
    binding: FragmentTimerBinding
) {
    val root = binding.root
    val timerText = binding.timeLabel
    val blackCover = binding.blackCover
    val whiteCover = binding.whiteCover
    val toolbar = binding.bar
    val timeView = binding.timeLabel
    val tutorialDot = binding.tutorialDot
    val boundsView = binding.main
    val labelChip = binding.labelView
}