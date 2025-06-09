package com.roblesdotdev.auth.presentation.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.auth.domain.PasswordValidationState
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.components.AnnotatedClickableText
import com.roblesdotdev.auth.presentation.components.SectionHeader
import com.roblesdotdev.auth.presentation.register.components.RegisterForm
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme

@Composable
fun RegisterScreenRoot(
    onLoginClick: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    RegisterScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                RegisterUIAction.OnLoginClick -> onLoginClick()
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun RegisterScreen(
    state: RegisterUIState,
    onAction: (RegisterUIAction) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .padding(top = 80.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SectionHeader(
                title = R.string.register_title,
                subtitle = R.string.register_subtitle,
            )
            Spacer(Modifier.height(32.dp))
            RegisterForm(
                state = state,
                onAction = onAction
            )
            AnnotatedClickableText(
                normalText = stringResource(R.string.alredy_have_an_account),
                clickableText = stringResource(R.string.sign_in),
                onClick = { onAction(RegisterUIAction.OnLoginClick) }
            )
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    HabitsAppTheme {
        RegisterScreen(
            state = RegisterUIState(
                passwordValidationState = PasswordValidationState(
                    hasMinLength = true
                )
            ),
            onAction = {}
        )
    }
}