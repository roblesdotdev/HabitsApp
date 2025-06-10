package com.roblesdotdev.auth.presentation.login

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
class LoginScreenViewModel @Inject constructor(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository,
): ViewModel() {
    var state by mutableStateOf(LoginUIState())
        private set
    private val eventChannel = Channel<LoginUIEvent>()
    val events = eventChannel.receiveAsFlow()

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
        viewModelScope.launch {
            val result = authRepository.login(
                email = state.email,
                password = state.password
            )
            state = state.copy(isSubmitting = false)
            when (result) {
                is Result.Failure -> {
                    if (result.error == DataError.Network.UNAUTHORIZED) {
                        eventChannel.send(LoginUIEvent.Error(
                            UIText.StringResource(R.string.error_invalid_credentials)
                        ))
                    } else {
                        eventChannel.send(LoginUIEvent.Error(result.error.asUIText()))
                    }
                }
                is Result.Success -> {
                    eventChannel.send(LoginUIEvent.LoginSuccess)
                }
            }
        }
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