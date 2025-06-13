package com.roblesdotdev.habits.domain

import com.roblesdotdev.core.domain.habit.Habit
import kotlinx.coroutines.flow.Flow

interface HabitsRepository {
    fun getHabitsForSelectedDate(date: Long): Flow<List<Habit>>
    suspend fun upsertHabit(habit: Habit)
}