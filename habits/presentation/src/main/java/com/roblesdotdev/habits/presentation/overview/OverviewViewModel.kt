package com.roblesdotdev.habits.presentation.overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(OverviewState())
        private set

    fun onAction(action: OverviewUIAction) {
        when (action) {
            is OverviewUIAction.ChangeSelectedDate -> changeSelectedDate(action.date)
            else -> {}
        }
    }

    private fun changeSelectedDate(date: ZonedDateTime) {
        state = state.copy(
            selectedDate = date
        )
    }
}