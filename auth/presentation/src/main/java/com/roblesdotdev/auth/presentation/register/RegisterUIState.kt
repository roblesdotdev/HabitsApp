package com.roblesdotdev.auth.presentation.register

import com.roblesdotdev.auth.domain.PasswordValidationState

data class RegisterUIState(
    val email: String = "",
    val password: String = "",
    val showPassword: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val isSubmitting: Boolean = false,
) {
    val canSubmit: Boolean
        get() = passwordValidationState.isValidPassword && !isSubmitting
}