package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository
import java.time.LocalDate
import java.time.ZonedDateTime

class CompleteDateUseCase(
    private val repo: HabitsRepository
) {
    suspend operator fun invoke(habit: Habit, date: ZonedDateTime) {
        val updatedDates = habit.completedDates.toggle(date.toLocalDate())
        repo.upsertHabit(habit.copy(completedDates = updatedDates))
    }

    private fun List<LocalDate>.toggle(value: LocalDate): List<LocalDate> =
        if (contains(value)) this - value else this + value
}