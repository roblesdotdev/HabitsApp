package com.roblesdotdev.core.database.mappers

import com.roblesdotdev.core.database.entity.HabitEntity
import com.roblesdotdev.core.domain.extension.toStartOfDateTimestamp
import com.roblesdotdev.core.domain.extension.toTimeStamp
import com.roblesdotdev.core.domain.extension.toZonedDateTime
import com.roblesdotdev.core.domain.habit.Habit
import java.time.DayOfWeek

fun HabitEntity.toDomain(): Habit {
    return Habit(
        id = this.id,
        name = this.name,
        category = this.category,
        frequency = this.frequency.map { DayOfWeek.of(it) },
        completedDates = this.completedDates.map { it.toZonedDateTime().toLocalDate() },
        reminder = this.reminder.toZonedDateTime().toLocalTime(),
        startDate = this.startDate.toZonedDateTime()
    )
}

fun Habit.toEntity(): HabitEntity {
    return HabitEntity(
        id = this.id,
        name = this.name,
        category = this.category,
        frequency = this.frequency.map { it.value },
        completedDates = this.completedDates.map { it.toZonedDateTime().toTimeStamp() },
        reminder = this.reminder.toZonedDateTime().toTimeStamp(),
        startDate = this.startDate.toStartOfDateTimestamp()
    )
}