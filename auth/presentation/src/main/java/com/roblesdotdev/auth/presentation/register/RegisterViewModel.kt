package com.roblesdotdev.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roblesdotdev.auth.domain.AuthRepository
import com.roblesdotdev.auth.domain.UserDataValidator
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.core.domain.util.DataError
import com.roblesdotdev.core.domain.util.Result
import com.roblesdotdev.core.presentation.ui.UIText
import com.roblesdotdev.core.presentation.ui.asUIText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository,
): ViewModel() {
    var state by mutableStateOf(RegisterUIState())
    private val eventChannel = Channel<RegisterUIEvent>()
    val events = eventChannel.receiveAsFlow()

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
        viewModelScope.launch {
            val result = authRepository.register(
                email = state.email,
                password = state.password
            )
            state = state.copy(isSubmitting = false)
            when (result) {
                is Result.Failure -> {
                    if (result.error == DataError.Network.CONFLICT) {
                        eventChannel.send(RegisterUIEvent.Error(UIText.StringResource(
                            R.string.error_email_exists,
                        )))
                    } else {
                       eventChannel.send(RegisterUIEvent.Error(result.error.asUIText()))
                    }
                }
                is Result.Success -> {
                    eventChannel.send(RegisterUIEvent.RegistrationSuccess)
                }
            }
        }
    }

    fun togglePasswordVisibility() {
        state = state.copy(showPassword = !state.showPassword)
    }

    fun changeEmail(email: String) {
        state = state.copy(
            email = email,
            isValidEmail = userDataValidator.isValidEmail(email)
        )
    }

    fun changePassword(password: String) {
        state = state.copy(
            password = password,
            passwordValidationState = userDataValidator.validatePassword(password)
        )
    }
}