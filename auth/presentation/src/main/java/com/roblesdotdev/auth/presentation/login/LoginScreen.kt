package com.roblesdotdev.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.auth.presentation.components.AnnotatedClickableText
import com.roblesdotdev.auth.presentation.components.SectionHeader
import com.roblesdotdev.auth.presentation.login.components.LoginForm
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.ui.ObserveAsEvent

@Composable
fun LoginScreenRoot(
    viewModel: LoginScreenViewModel = hiltViewModel(),
    onNavigateToRegister: () -> Unit,
    onLoginSuccess: () -> Unit,
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    ObserveAsEvent(viewModel.events) { event ->
        when (event) {
            is LoginUIEvent.Error -> {
                keyboardController?.hide()
                Toast.makeText(
                    context,
                    event.error.asString(context),
                    Toast.LENGTH_SHORT
                ).show()
            }
            LoginUIEvent.LoginSuccess -> {
                keyboardController?.hide()
                Toast.makeText(
                    context,
                    R.string.login_success,
                    Toast.LENGTH_SHORT
                ).show()

                onLoginSuccess()
            }
        }
    }
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
            AnnotatedClickableText(
                normalText = stringResource(R.string.dont_have_an_account),
                clickableText = stringResource(R.string.sign_up),
                onClick = { onAction(LoginUIAction.OnRegisterClick)}
            )
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
