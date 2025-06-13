package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository
import kotlinx.coroutines.flow.Flow

class GetHabitsForDateUseCase(
    private val repo: HabitsRepository
) {
    operator fun invoke(date: Long): Flow<List<Habit>> {
       return repo.getHabitsForSelectedDate(date)
    }
}