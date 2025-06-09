package com.roblesdotdev.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(RegisterUIState())

    fun onAction(action: RegisterUIAction) {
        when (action) {
            RegisterUIAction.OnRegisterClick -> register()
            RegisterUIAction.OnTogglePasswordVisibility -> togglePasswordVisibility()
            is RegisterUIAction.OnChangeEmail -> changeEmail(action.email)
            is RegisterUIAction.OnChangePassword -> changePassword(action.password)
            else -> {}
        }
    }

    fun register() {
        state = state.copy(isSubmitting = true)
    }

    fun togglePasswordVisibility() {
        state = state.copy(showPassword = !state.showPassword)
    }

    fun changeEmail(email: String) {
        state = state.copy(email = email)
    }

    fun changePassword(password: String) {
        state = state.copy(password = password)
    }
}