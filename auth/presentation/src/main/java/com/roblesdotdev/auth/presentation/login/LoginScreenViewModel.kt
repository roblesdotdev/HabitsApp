package com.roblesdotdev.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.roblesdotdev.auth.domain.UserDataValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userDataValidator: UserDataValidator
): ViewModel() {
    var state by mutableStateOf(LoginUIState())
        private set

    fun onAction(action: LoginUIAction) {
       when(action) {
           is LoginUIAction.OnChangeEmail -> changeEmail(action.email)
           is LoginUIAction.OnChangePassword -> changePassword(action.password)
           LoginUIAction.OnTogglePasswordVisibility -> togglePasswordVisibility()
           LoginUIAction.OnLoginClick -> login()
           else -> {}
       }
    }

    private fun login() {
        state = state.copy(
            isSubmitting = true,
        )
    }

    private fun togglePasswordVisibility() {
        state = state.copy(
            showPassword = !state.showPassword
        )
    }

    private fun changeEmail(email: String) {
        state = state.copy(
            email = email,
            isValidEmail = userDataValidator.isValidEmail(email),
        )
    }

    private fun changePassword(password: String) {
        state = state.copy(
            password = password
        )
    }
}