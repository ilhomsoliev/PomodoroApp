package com.ilhomsoliev.pomodoroapp.feature.timer

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.ilhomsoliev.pomodoroapp.R
import com.ilhomsoliev.pomodoroapp.shared.base_fragment.AbsMainActivityFragment
import com.ilhomsoliev.pomodoroapp.databinding.FragmentTimerBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TimerFragment : AbsMainActivityFragment(R.layout.fragment_timer) {

    private var _binding: TimerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBinding = FragmentTimerBinding.bind(view)
        _binding = TimerBinding(homeBinding)
        setupListeners()
        baseViewModel.timerStateFlow.onEach {
            binding.timerText.text = it.displaySeconds
        }.launchIn(lifecycleScope)
    }

    private fun setupListeners() {
        binding.controlButton.setOnClickListener {
            baseViewModel.toggleTime(60000)
        }
    }
}