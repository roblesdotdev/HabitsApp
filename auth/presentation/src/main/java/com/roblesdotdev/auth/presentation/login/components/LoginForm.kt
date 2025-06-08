package com.roblesdotdev.auth.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.login.LoginUIAction
import com.roblesdotdev.auth.presentation.login.LoginUIState
import com.roblesdotdev.core.presentation.designsystem.EyeClosedIcon
import com.roblesdotdev.core.presentation.designsystem.EyeOpenIcon
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
        DefaultTextField(
            enabled = !state.isSubmitting,
            value = state.email,
            onValueChange = { onAction(LoginUIAction.OnChangeEmail(it)) },
            placeholder = stringResource(R.string.email_placeholder),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
        )
        DefaultTextField(
            enabled = !state.isSubmitting,
            value = state.password,
            onValueChange = { onAction(LoginUIAction.OnChangePassword(it)) },
            placeholder = stringResource(R.string.password_placeholder),
            visualTransformation = if (state.showPassword) VisualTransformation.None else PasswordVisualTransformation(),
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
            trailingIcon = {
                IconButton(onClick = {
                    onAction(LoginUIAction.OnTogglePasswordVisibility)
                }) {
                    val icon = if (!state.showPassword) EyeClosedIcon else EyeOpenIcon
                    Icon(
                        icon, contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        )
        Spacer(Modifier.height(8.dp))
        PrimaryButton(
            text = stringResource(R.string.sign_in), onClick = {
                onAction(LoginUIAction.OnLoginClick)
            },
            enabled = !state.isSubmitting
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