package com.roblesdotdev.habits.domain.usecase

import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.habits.domain.HabitsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.time.ZonedDateTime

class GetHabitsForDateUseCase(
    private val repo: HabitsRepository
) {
    operator fun invoke(date: ZonedDateTime): Flow<List<Habit>> {
        return repo.getHabitsForSelectedDate(date).map { habit ->
            habit.filter { it.frequency.contains(date.dayOfWeek) }
        }.distinctUntilChanged()
    }
}