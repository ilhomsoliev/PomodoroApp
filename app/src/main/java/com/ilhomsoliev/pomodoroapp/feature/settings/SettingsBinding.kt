package com.ilhomsoliev.pomodoroapp.feature.settings

import com.ilhomsoliev.pomodoroapp.databinding.FragmentSettingsBinding

class SettingsBinding(
    binding: FragmentSettingsBinding
) {

    val toolbar = binding.appBarLayout.toolbar
    val timerDurationPref = binding.timerDurationPref.binding

}

