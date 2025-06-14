package com.roblesdotdev.habits.presentation.detail

sealed interface DetailUIEvent {
    data object OnCompleteSave: DetailUIEvent
}