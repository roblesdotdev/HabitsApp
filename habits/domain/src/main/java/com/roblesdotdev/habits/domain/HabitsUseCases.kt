package com.roblesdotdev.habits.domain

import com.roblesdotdev.habits.domain.usecase.CompleteDateUseCase
import com.roblesdotdev.habits.domain.usecase.GetHabitByIdUseCase
import com.roblesdotdev.habits.domain.usecase.GetHabitsForDateUseCase
import com.roblesdotdev.habits.domain.usecase.UpsertHabitUseCase

data class HabitsUseCases(
    val completeDateUseCase: CompleteDateUseCase,
    val getHabitsForDateUseCase: GetHabitsForDateUseCase,
    val getHabitByIdUseCase: GetHabitByIdUseCase,
    val upsertHabitUseCase: UpsertHabitUseCase
)