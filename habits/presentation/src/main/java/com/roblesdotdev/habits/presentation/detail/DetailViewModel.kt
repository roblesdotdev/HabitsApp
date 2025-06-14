package com.roblesdotdev.habits.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.DayOfWeek
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(DetailUIState())
        private set

    fun onAction(action: DetailUIAction) {
        when(action) {
            is DetailUIAction.ChangeName -> changeName(action.name)
            is DetailUIAction.ChangeCategory -> changeCategory(action.category)
            is DetailUIAction.ChangeReminder -> changeReminder(action.reminder)
            is DetailUIAction.ToggleFrequencyDay -> toggleFrequencyDay(action.dayOfWeek)
            else -> {}
        }
    }

    private fun toggleFrequencyDay(day: DayOfWeek) {
        state = state.copy(
            frequency = if (state.frequency.contains(day)) {
                state.frequency - day
            } else {
                state.frequency + day
            }
        )
    }

    private fun changeReminder(reminder: LocalTime) {
        state = state.copy(
            reminder = reminder
        )
    }

    private fun changeCategory(category: String) {
        state = state.copy(
            category = category
        )
    }

    private fun changeName(name: String) {
        state = state.copy(
            name = name
        )
    }
}