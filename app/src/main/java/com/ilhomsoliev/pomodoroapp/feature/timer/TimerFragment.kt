package com.ilhomsoliev.pomodoroapp.feature.timer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.core.PreferenceUtil
import com.ilhomsoliev.pomodoroapp.databinding.FragmentTimerBinding
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TimerFragment : AbsMainActivityFragment(R.layout.fragment_timer) {

    private var _binding: TimerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBinding = FragmentTimerBinding.bind(view)

        _binding = TimerBinding(homeBinding)

        if (PreferenceUtil.isFirstRun) {
            // show app intro
            /*val i = Intent(this, MainIntroActivity::class.java)
            startActivity(i)
            PreferenceUtil.isFirstRun = false*/
        }

        setupListeners()

        baseViewModel.timerStateFlow.onEach {
            binding.timerText.text = it.displaySeconds
        }.launchIn(lifecycleScope)
        binding.controlButton.text = baseViewModel.isTimerRunning.toString()
    }

    private fun setupListeners() {
        binding.controlButton.setOnClickListener {
            baseViewModel.toggleTime(60000)
            binding.controlButton.text = baseViewModel.isTimerRunning.toString()
        }
    }
}