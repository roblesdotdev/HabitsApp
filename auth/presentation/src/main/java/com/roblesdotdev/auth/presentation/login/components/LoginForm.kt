package com.roblesdotdev.auth.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.components.EmailTextField
import com.roblesdotdev.auth.presentation.components.PasswordTextField
import com.roblesdotdev.auth.presentation.login.LoginUIAction
import com.roblesdotdev.auth.presentation.login.LoginUIState
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTextField
import com.roblesdotdev.core.presentation.designsystem.components.PrimaryButton

@Composable
fun LoginForm(
    state: LoginUIState,
    onAction: (LoginUIAction) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EmailTextField(
            enabled = !state.isSubmitting,
            value = state.email,
            onValueChange = { onAction(LoginUIAction.OnChangeEmail(it)) },
            placeholder = stringResource(R.string.email_placeholder),
            isValidEmail = state.isValidEmail
        )
        PasswordTextField(
            value = state.password,
            enabled = !state.isSubmitting,
            onValueChange = { onAction(LoginUIAction.OnChangePassword(it)) },
            showPassword = state.showPassword,
            placeholder = stringResource(R.string.password_placeholder),
            onToggleShowPassword = { onAction(LoginUIAction.OnTogglePasswordVisibility) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onAction(LoginUIAction.OnLoginClick)
                    focusManager.clearFocus()
                }
            ),
        )
        Spacer(Modifier.height(8.dp))
        PrimaryButton(
            enabled = state.canSubmit,
            text = stringResource(R.string.sign_in), onClick = {
                onAction(LoginUIAction.OnLoginClick)
            },
        )

    }
}

@Preview
@Composable
private fun LoginFormPreview() {
    HabitsAppTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            LoginForm(state = LoginUIState(), onAction = {})
        }
    }
}