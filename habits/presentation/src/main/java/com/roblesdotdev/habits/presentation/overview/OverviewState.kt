package com.roblesdotdev.habits.presentation.overview

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.data.extension.toStartOfDateTimestamp
import com.roblesdotdev.habits.data.extension.toTimeStamp
import com.roblesdotdev.habits.data.extension.toZonedDateTime
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class OverviewState(
    val today: ZonedDateTime = ZonedDateTime.now(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now(),
    val habits: List<Habit> = mockHabits
) {
    val formattedCurrentDate: String
        get() = selectedDate.format(
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH)
        )
}

val mockHabits = (1..10).map {
    val dates = mutableListOf<LocalDate>()
    if (it % 2 == 0) {
        dates.add(LocalDate.now())
    }
    Habit(
        id = "$it",
        name = "Habit $it",
        category = "Category for habit $it",
        completedDates = dates.map { it.toZonedDateTime().toStartOfDateTimestamp() },
        reminder = LocalTime.now().toZonedDateTime().toTimeStamp(),
        startDate = ZonedDateTime.now().toStartOfDateTimestamp(),
        frequency = listOf(),
    )
}