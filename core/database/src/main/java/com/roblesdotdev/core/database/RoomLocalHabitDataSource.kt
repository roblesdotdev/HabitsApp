package com.roblesdotdev.core.database

import android.database.sqlite.SQLiteFullException
import com.roblesdotdev.core.database.dao.HabitsDao
import com.roblesdotdev.core.database.mappers.toDomain
import com.roblesdotdev.core.database.mappers.toEntity
import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.core.domain.habit.HabitId
import com.roblesdotdev.core.domain.habit.LocalHabitDataSource
import com.roblesdotdev.core.domain.util.DataError
import com.roblesdotdev.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalHabitDataSource(
    private val dao: HabitsDao
) : LocalHabitDataSource {
    override fun getHabitsForSelectedDate(date: Long): Flow<List<Habit>> {
        return dao.getAllHabitsForSelectedDate(date).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun upsertHabit(habit: Habit): Result<HabitId, DataError.Local> {
        return try {
            dao.upsertHabit(habit.toEntity())
            Result.Success(habit.id)
        } catch(_: SQLiteFullException) {
            Result.Failure(DataError.Local.DISK_FULL)
        } catch (_: Exception){
            Result.Failure(DataError.Local.UNKNOWN)
        }
    }

    override suspend fun getHabitById(id: HabitId): Result<Habit, DataError.Local> {
        return try {
            val habit = dao.getHabitById(id)
            if (habit != null) {
                Result.Success(habit.toDomain())
            } else {
                Result.Failure(DataError.Local.NOT_FOUND)
            }
        } catch (_: Exception) {
            Result.Failure(DataError.Local.UNKNOWN)
        }
    }

}