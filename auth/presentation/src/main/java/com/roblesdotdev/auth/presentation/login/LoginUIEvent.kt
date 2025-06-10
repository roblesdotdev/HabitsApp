package com.roblesdotdev.auth.presentation.login

import com.roblesdotdev.core.presentation.ui.UIText

sealed interface LoginUIEvent {
    data object LoginSuccess : LoginUIEvent
    data class Error(val error: UIText) : LoginUIEvent
}