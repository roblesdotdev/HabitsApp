package com.roblesdotdev.auth.presentation.login

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val showPassword: Boolean = false,
    val isSubmitting: Boolean = false,
    val isValidEmail: Boolean = false,
) {
    val canSubmit: Boolean
        get() = isValidEmail && !isSubmitting && password.isNotBlank()
}