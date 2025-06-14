package com.roblesdotdev.habits.presentation.detail

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

data class DetailUIState(
    val id: String? = null,
    val name: String = "",
    val category: String = "",
    val frequency: List<DayOfWeek> = listOf(),
    val reminder: LocalTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES),
    val startDate: ZonedDateTime = ZonedDateTime.now(),
    val completedDates: List<LocalDate> = emptyList(),
)