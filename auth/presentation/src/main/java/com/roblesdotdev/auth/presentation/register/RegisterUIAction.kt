package com.roblesdotdev.auth.presentation.register

sealed interface RegisterUIAction {
    data class OnChangeEmail(val email: String): RegisterUIAction
    data class OnChangePassword(val password: String): RegisterUIAction
    data object OnTogglePasswordVisibility: RegisterUIAction
    data object OnLoginClick: RegisterUIAction
    data object OnRegisterClick: RegisterUIAction
}