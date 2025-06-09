package com.roblesdotdev.auth.presentation.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.components.EmailTextField
import com.roblesdotdev.auth.presentation.components.PasswordTextField
import com.roblesdotdev.auth.presentation.register.RegisterUIAction
import com.roblesdotdev.auth.presentation.register.RegisterUIState
import com.roblesdotdev.core.presentation.designsystem.components.PrimaryButton

@Composable
fun RegisterForm(
    state: RegisterUIState,
    onAction: (RegisterUIAction) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        EmailTextField(
            enabled = !state.isSubmitting,
            value = state.email,
            onValueChange = { onAction(RegisterUIAction.OnChangeEmail(it)) },
            placeholder = stringResource(R.string.email_placeholder),
        )
        PasswordTextField(
            value = state.password,
            enabled = !state.isSubmitting,
            onValueChange = { onAction(RegisterUIAction.OnChangePassword(it)) },
            showPassword = state.showPassword,
            onToggleShowPassword = { onAction(RegisterUIAction.OnTogglePasswordVisibility) },
            placeholder = stringResource(R.string.password_placeholder),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onAction(RegisterUIAction.OnLoginClick)
                    focusManager.clearFocus()
                }
            ),
        )
        PasswordRequirement(
            text = "Minimum of 8 characters",
            isValid = state.passwordValidationState.hasMinLength
        )
        PasswordRequirement(
            text = "Include at least one uppercase letter",
            isValid = state.passwordValidationState.hasUpperCaseCharacter
        )
        PasswordRequirement(
            text = "Include at least one lowercase letter",
            isValid = state.passwordValidationState.hasLowerCaseCharacter
        )
        PasswordRequirement(
            text = "Include at least one number",
            isValid = state.passwordValidationState.hasNumber
        )
        PasswordRequirement(
            text = "Include at least one special character",
            isValid = state.passwordValidationState.hasSpecialChar
        )
        Spacer(Modifier.height(8.dp))
        PrimaryButton(
            enabled = state.canSubmit,
            onClick = { onAction(RegisterUIAction.OnRegisterClick) },
            text = stringResource(R.string.create_account)
        )
    }
}