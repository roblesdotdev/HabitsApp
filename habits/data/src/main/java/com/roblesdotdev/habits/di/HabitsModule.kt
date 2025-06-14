package com.roblesdotdev.habits.di

import com.roblesdotdev.habits.data.InMemoryHabitsRepository
import com.roblesdotdev.habits.domain.HabitsRepository
import com.roblesdotdev.habits.domain.HabitsUseCases
import com.roblesdotdev.habits.domain.usecase.CompleteDateUseCase
import com.roblesdotdev.habits.domain.usecase.GetHabitByIdUseCase
import com.roblesdotdev.habits.domain.usecase.GetHabitsForDateUseCase
import com.roblesdotdev.habits.domain.usecase.UpsertHabitUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HabitsModule {
    @Provides
    @Singleton
    fun provideHabitsRepository(): HabitsRepository {
        return InMemoryHabitsRepository()
    }

    @Provides
    @Singleton
    fun provideHabitsUseCases(repo: HabitsRepository): HabitsUseCases {
        return HabitsUseCases(
            completeDateUseCase = CompleteDateUseCase(repo),
            getHabitsForDateUseCase = GetHabitsForDateUseCase(repo),
            getHabitByIdUseCase = GetHabitByIdUseCase(repo),
            upsertHabitUseCase = UpsertHabitUseCase(repo)
        )
    }
}