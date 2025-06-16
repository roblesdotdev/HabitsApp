package com.roblesdotdev.core.domain.habit

import com.roblesdotdev.core.domain.util.DataError
import com.roblesdotdev.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

typealias HabitId = String

interface LocalHabitDataSource {
    fun getHabitsForSelectedDate(date: Long) : Flow<List<Habit>>

    suspend fun upsertHabit(habit: Habit): Result<HabitId, DataError.Local>

    suspend fun getHabitById(id: HabitId): Result<Habit, DataError.Local>
}