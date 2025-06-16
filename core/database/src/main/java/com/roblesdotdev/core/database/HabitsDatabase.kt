package com.roblesdotdev.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.roblesdotdev.core.database.converters.HabitTypeConverter
import com.roblesdotdev.core.database.dao.HabitsDao
import com.roblesdotdev.core.database.entity.HabitEntity

@Database(
    entities = [HabitEntity::class],
    version = 1,
)
@TypeConverters(HabitTypeConverter::class)
abstract class HabitsDatabase : RoomDatabase() {
    abstract val habitsDao:  HabitsDao
}