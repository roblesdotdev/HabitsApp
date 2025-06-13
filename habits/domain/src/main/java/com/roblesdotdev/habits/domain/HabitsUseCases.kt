package com.roblesdotdev.habits.domain

import com.roblesdotdev.habits.domain.usecase.CompleteDateUseCase
import com.roblesdotdev.habits.domain.usecase.GetHabitsForDateUseCase

data class HabitsUseCases(
    val completeDateUseCase: CompleteDateUseCase,
    val getHabitsForDateUseCase: GetHabitsForDateUseCase,
)