package com.roblesdotdev.habits.domain

import com.roblesdotdev.core.domain.habit.Habit
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

interface HabitsRepository {
    fun getHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>>
    suspend fun upsertHabit(habit: Habit)
}