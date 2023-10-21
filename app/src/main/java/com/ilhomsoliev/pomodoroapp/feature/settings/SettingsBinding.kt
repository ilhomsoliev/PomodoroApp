package com.ilhomsoliev.pomodoroapp.feature.settings

import com.ilhomsoliev.pomodoroapp.databinding.FragmentSettingsBinding

class SettingsBinding(
    binding: FragmentSettingsBinding
) {

    val toolbar = binding.appBarLayout.toolbar
    val timerDurationPref = binding.timerDurationPref.binding
    val developersPref = binding.developersPref.binding
    val languagePref = binding.languagePref.binding
    val vibrationSoundPref = binding.vibrationSoundPref.binding
    val themePref = binding.themePref.binding
    val notificationSoundPref = binding.notificationSoundPref.binding

}

