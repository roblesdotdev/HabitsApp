package com.roblesdotdev.auth.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.components.SectionHeader
import com.roblesdotdev.auth.presentation.login.components.LoginForm
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme

@Composable
fun LoginScreenRoot(
    viewModel: LoginScreenViewModel = hiltViewModel(),
    onNavigateToRegister: () -> Unit,
) {
    LoginScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                LoginUIAction.OnRegisterClick -> onNavigateToRegister()
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginUIState,
    onAction: (LoginUIAction) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .padding(top = 80.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SectionHeader(
                title = R.string.login_title,
                subtitle = R.string.login_subtitle,
            )
            Spacer(Modifier.height(32.dp))
            LoginForm(
                state = state,
                onAction = onAction,
            )
            TextButton(
                enabled = !state.isSubmitting,
                onClick = {
                    onAction(LoginUIAction.OnRegisterClick)
                }
            ) {
                Text(
                    buildAnnotatedString {
                        append(stringResource(R.string.dont_have_an_account))
                        append(" ")
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.onBackground,
                                fontWeight = FontWeight.Medium,
                            )
                        ) {
                            append(stringResource(R.string.sign_up))
                        }
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoginContentPreview() {
    HabitsAppTheme {
        LoginScreen(
            state = LoginUIState(),
            onAction = {},
        )
    }
}
