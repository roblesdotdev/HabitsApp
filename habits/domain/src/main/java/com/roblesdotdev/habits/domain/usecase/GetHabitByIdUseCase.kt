package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository

class GetHabitByIdUseCase(
    private val repository: HabitsRepository
) {
    suspend operator fun invoke(id: String): Habit {
        return repository.getHabitById(id)
    }
}