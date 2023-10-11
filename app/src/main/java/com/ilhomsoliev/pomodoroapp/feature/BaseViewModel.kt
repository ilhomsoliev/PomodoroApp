package com.ilhomsoliev.pomodoroapp.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {
    private var _timerStateFlow = MutableStateFlow(TimerState())
    val timerStateFlow: StateFlow<TimerState> = _timerStateFlow

    private var job: Job? = null

    fun toggleTime(totalSeconds: Int) {
        job = if (job == null || job?.isCompleted == true) {
            viewModelScope.launch {
                initTimer(totalSeconds) { remainingTime -> TimerState(remainingTime, totalSeconds) }
                    .onCompletion { _timerStateFlow.emit(TimerState()) }
                    .collect { _timerStateFlow.emit(it) }
            }
        } else {
            job?.cancel()
            null
        }
    }

    /**
     * The timer emits the total seconds immediately.
     * Each second after that, it will emit the next value.
     */
    private fun <DisplayState> initTimer(
        totalSeconds: Int,
        onTick: (Int) -> DisplayState
    ): Flow<DisplayState> =
//        generateSequence(totalSeconds - 1 ) { it - 1 }.asFlow()
        (totalSeconds - 1 downTo 0).asFlow() // Emit total - 1 because the first was emitted onStart
            .onEach { delay(1000) } // Each second later emit a number
            .onStart { emit(totalSeconds) } // Emit total seconds immediately
            .conflate() // In case the operation onTick takes some time, conflate keeps the time ticking separately
            .transform { remainingSeconds: Int ->
                emit(onTick(remainingSeconds))
            }

}

data class TimerState(
    val secondsRemaining: Int? = null,
    val totalSeconds: Int = 60,
    val textWhenStopped: String = "-"
) {
    val displaySeconds: String = (secondsRemaining ?: textWhenStopped).toString()

    // Show 100% if seconds remaining is null
    val progressPercentage: Float = (secondsRemaining ?: totalSeconds) / totalSeconds.toFloat()

    override fun toString(): String =
        "Seconds Remaining $secondsRemaining, totalSeconds: $totalSeconds, progress: $progressPercentage"

}