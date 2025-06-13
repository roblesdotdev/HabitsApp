package com.roblesdotdev.habits.presentation.overview

import com.roblesdotdev.core.domain.habit.Habit
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class OverviewState(
    val today: ZonedDateTime = ZonedDateTime.now(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now(),
    val habits: List<Habit> = emptyList()
) {
    val formattedCurrentDate: String
        get() = selectedDate.format(
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH)
        )
}
