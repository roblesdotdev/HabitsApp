package com.roblesdotdev.habits.presentation.overview

import java.time.ZonedDateTime

sealed interface OverviewUIAction {
    data object NavigateToSettings: OverviewUIAction
    data class NavigateToDetail(val id: String?): OverviewUIAction
    data class ChangeSelectedDate(val date: ZonedDateTime): OverviewUIAction
    data class ToggleComplete(val id: String): OverviewUIAction
}