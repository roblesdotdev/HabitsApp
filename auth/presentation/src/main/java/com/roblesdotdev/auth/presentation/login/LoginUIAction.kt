package com.roblesdotdev.auth.presentation.login

sealed interface LoginUIAction {
    data class OnChangeEmail(val email: String) : LoginUIAction
    data class OnChangePassword(val password: String) : LoginUIAction
    data object OnTogglePasswordVisibility : LoginUIAction
    data object OnLoginClick : LoginUIAction
    data object OnRegisterClick : LoginUIAction
}