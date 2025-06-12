package com.roblesdotdev.habits.presentation.overview

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

data class OverviewState(
    val today: ZonedDateTime = ZonedDateTime.now(),
    val selectedDate: ZonedDateTime = ZonedDateTime.now()
) {
    val formattedCurrentDate: String
        get() = selectedDate.format(
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH)
        )
}