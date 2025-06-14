package com.roblesdotdev.habits.data

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZonedDateTime
import kotlin.random.Random

class InMemoryHabitsRepository: HabitsRepository {
    private val mockHabits = (1..15).map { it ->
        val dates = mutableListOf<LocalDate>()
        if (it % 2 == 0) {
            dates.add(LocalDate.now())
        }
        val randomFrequency = List(Random.nextInt(1, 8)) { Random.nextInt(1, 8) }
        val daysOfWeek = randomFrequency.map { DayOfWeek.of(it) }

        Habit(
            id = "$it",
            name = "Habit $it",
            category = "Category for $it",
            completedDates = dates,
            reminder = LocalTime.now(),
            startDate = ZonedDateTime.now(),
            frequency = daysOfWeek,
        )
    }.toMutableList()

    override fun getHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>> {
        return flowOf(mockHabits)
    }

    override suspend fun upsertHabit(habit: Habit) {
        val idx = mockHabits.indexOfFirst { it.id == habit.id }
        if (idx != -1) {
            mockHabits.removeAt(idx)
            mockHabits.add(idx, habit)
        } else {
            mockHabits.add(habit)
        }
    }

    override suspend fun getHabitById(id: String): Habit {
        return mockHabits.first { it.id == id }
    }
}