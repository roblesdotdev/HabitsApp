package com.roblesdotdev.habitsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.core.domain.preferences.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: UserPreferences
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            val isCompleteOnboarding = preferences.isCompleteOnboarding()
            state = state.copy(
                isCompleteOnboarding = isCompleteOnboarding,
                isLoading = false
            )
        }
    }
}