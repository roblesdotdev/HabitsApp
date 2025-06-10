package com.roblesdotdev.habitsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.core.domain.preferences.UserPreferences
import com.roblesdotdev.core.domain.session.SessionStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: UserPreferences,
    private val sessionStorage: SessionStorage,
) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            val isCompleteOnboarding = preferences.isCompleteOnboarding()
            val sessionInfo = sessionStorage.get()
            state = state.copy(
                isCompleteOnboarding = isCompleteOnboarding,
                isLoading = false,
                isLoggedIn = sessionInfo != null
            )
        }
    }
}