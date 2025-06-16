package com.roblesdotdev.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.roblesdotdev.core.database.entity.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitsDao {
    @Upsert
    suspend fun upsertHabit(habit: HabitEntity)

    @Query("SELECT * FROM HabitEntity WHERE id = :id")
    suspend fun getHabitById(id: String): HabitEntity?

    @Query("SELECT * FROM HabitEntity WHERE startDate <= :date")
    fun getAllHabitsForSelectedDate(date: Long): Flow<List<HabitEntity>>
}