package com.roblesdotdev.habits.presentation.detail

import java.time.DayOfWeek
import java.time.LocalTime
import java.time.temporal.ChronoUnit

data class DetailUIState(
    val name: String = "",
    val category: String = "",
    val frequency: List<DayOfWeek> = listOf(),
    val reminder: LocalTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES)
)