package com.roblesdotdev.habits.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalTime
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: HabitsUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    var state by mutableStateOf(DetailUIState())
        private set
    private val eventChannel = Channel<DetailUIEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        val id = savedStateHandle.get<String?>("id")
        if (id != null) {
            loadCurrentHabit(id)
        }
    }

    private fun loadCurrentHabit(id: String) {
        viewModelScope.launch {
            val habit = useCases.getHabitByIdUseCase(id) ?: return@launch
            state = state.copy(
                id = habit.id,
                name = habit.name,
                category = habit.category,
                frequency = habit.frequency,
                reminder = habit.reminder,
                completedDates = habit.completedDates,
                startDate = habit.startDate,
            )
        }
    }

    fun onAction(action: DetailUIAction) {
        when(action) {
            is DetailUIAction.ChangeName -> changeName(action.name)
            is DetailUIAction.ChangeCategory -> changeCategory(action.category)
            is DetailUIAction.ChangeReminder -> changeReminder(action.reminder)
            is DetailUIAction.ToggleFrequencyDay -> toggleFrequencyDay(action.dayOfWeek)
            DetailUIAction.SaveHabit -> saveHabit()
            else -> {}
        }
    }

    private fun saveHabit() {
        viewModelScope.launch {
            useCases.upsertHabitUseCase(
                habit = Habit(
                    id = state.id ?: UUID.randomUUID().toString(),
                    name = state.name,
                    category = state.category,
                    frequency = state.frequency,
                    completedDates = state.completedDates,
                    reminder = state.reminder,
                    startDate = state.startDate,
                )
            )
            eventChannel.send(DetailUIEvent.OnCompleteSave)
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