package com.roblesdotdev.core.database.di

import android.content.Context
import androidx.room.Room
import com.roblesdotdev.core.database.HabitsDatabase
import com.roblesdotdev.core.database.RoomLocalHabitDataSource
import com.roblesdotdev.core.database.converters.HabitTypeConverter
import com.roblesdotdev.core.database.dao.HabitsDao
import com.roblesdotdev.core.domain.habit.LocalHabitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideHabitsDao(@ApplicationContext context: Context): HabitsDao {
        return Room.databaseBuilder(
            context,
            HabitsDatabase::class.java,
            "habits.db"
        ).addTypeConverter(
            HabitTypeConverter()
        ).build().habitsDao
    }

    @Provides
    @Singleton
    fun provideLocalHabitDataSource(dao: HabitsDao): LocalHabitDataSource {
        return RoomLocalHabitDataSource(dao)
    }
}