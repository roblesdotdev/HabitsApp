package com.roblesdotdev.habits.presentation.detail

import java.time.DayOfWeek
import java.time.LocalTime

sealed interface DetailUIAction {
    data object NavigateBack: DetailUIAction
    data class ChangeName(val name: String): DetailUIAction
    data class ChangeCategory(val category: String): DetailUIAction
    data class ChangeReminder(val reminder: LocalTime): DetailUIAction
    data class ToggleFrequencyDay(val dayOfWeek: DayOfWeek) : DetailUIAction
    data object SaveHabit : DetailUIAction
}