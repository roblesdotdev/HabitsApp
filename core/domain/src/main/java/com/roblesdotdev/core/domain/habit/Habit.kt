package com.roblesdotdev.core.domain.habit

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime

/**
 * Represents a user-defined habit.
 *
 * @property id Unique identifier for the habit. If null, a new habit will be created;
 * otherwise, the existing one will be updated.
 * @property name The name of the habit.
 * @property category A description of the habit.
 * @property frequency Days of the week when the habit should be performed,
 * represented as integers from 1 (Monday) to 7 (Sunday), following the ISO-8601 standard.
 * @property completedDates List of dates when the habit was completed,
 * stored as epoch milliseconds at the start of the day. Only the date part is relevant
 * (equivalent to LocalDate).
 * @property reminder The time of day to trigger a reminder for the habit,
 * stored as epoch milliseconds. Only the time part is relevant (equivalent to LocalTime).
 * @property startDate The date and time from which the habit becomes active,
 * stored as epoch milliseconds representing a ZonedDateTime (includes time zone context).
 */
data class Habit(
    val id: String?,
    val name: String,
    val category: String,
    val frequency: List<DayOfWeek>,
    val completedDates: List<LocalDate>,
    val reminder: LocalTime,
    val startDate: ZonedDateTime,
)