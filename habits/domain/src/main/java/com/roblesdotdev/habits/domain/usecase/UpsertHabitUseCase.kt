package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository

class UpsertHabitUseCase(
    private val habitsRepository: HabitsRepository
) {
    suspend operator fun invoke(habit: Habit) {
        habitsRepository.upsertHabit(habit)
    }
}