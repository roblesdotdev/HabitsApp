package com.roblesdotdev.habits.presentation.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.data.extension.toStartOfDateTimestamp
import com.roblesdotdev.habits.data.extension.toZonedDateTime
import com.roblesdotdev.habits.domain.HabitsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val useCases: HabitsUseCases
) : ViewModel() {
    var state by mutableStateOf(OverviewState())
        private set

    init {
        getHabits()
    }

    private fun getHabits() {
        viewModelScope.launch {
            useCases.getHabitsForDateUseCase(state.selectedDate.toStartOfDateTimestamp())
                .collectLatest { habits ->
                    state = state.copy(
                        habits = habits,
                    )
                }
        }
    }

    fun onAction(action: OverviewUIAction) {
        when (action) {
            is OverviewUIAction.ChangeSelectedDate -> changeSelectedDate(action.date)
            is OverviewUIAction.ToggleComplete -> toggleComplete(
                date = action.date,
                habit = action.habit,
            )
            else -> {}
        }
    }

    private fun changeSelectedDate(date: ZonedDateTime) {
        state = state.copy(
            selectedDate = date
        )
        getHabits()
    }

    private fun toggleComplete(habit: Habit, date: LocalDate) {
        viewModelScope.launch {
            useCases.completeDateUseCase(
                habit = habit,
                date = date.toZonedDateTime().toStartOfDateTimestamp(),
            )
        }
    }
}