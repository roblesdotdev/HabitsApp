package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository

class CompleteDateUseCase(
    private val repo: HabitsRepository
) {
    suspend operator fun invoke(habit: Habit, date: Long) {
        val updatedDates = habit.completedDates.toggle(date)
        repo.upsertHabit(habit.copy(completedDates = updatedDates))
    }

    private fun List<Long>.toggle(value: Long): List<Long> =
        if (contains(value)) this - value else this + value
}