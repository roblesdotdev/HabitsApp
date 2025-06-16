package com.roblesdotdev.habits.data

import com.roblesdotdev.core.domain.extension.toStartOfDateTimestamp
import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.core.domain.habit.LocalHabitDataSource
import com.roblesdotdev.core.domain.util.Result
import com.roblesdotdev.habits.domain.HabitsRepository
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime

class DefaultHabitsRepository(
    private val localDataSource: LocalHabitDataSource
) : HabitsRepository {
    override fun getHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        return localDataSource.getHabitsForSelectedDate(date.toStartOfDateTimestamp())
    }

    override suspend fun upsertHabit(habit: Habit) {
        localDataSource.upsertHabit(habit)
    }

    override suspend fun getHabitById(id: String): Habit? {
        return when (val result = localDataSource.getHabitById(id)) {
            is Result.Failure -> null
            is Result.Success -> result.data
        }
    }

}