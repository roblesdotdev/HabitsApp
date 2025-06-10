package com.roblesdotdev.auth.presentation.register

import com.roblesdotdev.core.presentation.ui.UIText

sealed interface RegisterUIEvent {
    data object RegistrationSuccess: RegisterUIEvent
    data class Error(val error: UIText) : RegisterUIEvent
}