package com.roblesdotdev.habits.presentation.overview

import java.time.ZonedDateTime

sealed interface OverviewUIAction {
    data object NavigateToDetail: OverviewUIAction
    data class ChangeSelectedDate(val date: ZonedDateTime): OverviewUIAction
}