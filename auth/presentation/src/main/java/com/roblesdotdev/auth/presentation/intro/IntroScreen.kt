package com.roblesdotdev.auth.presentation.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.PrimaryButton
import com.roblesdotdev.core.presentation.designsystem.components.SecondaryButton

@Composable
fun IntroScreenRoot(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    IntroScreen(onAction = { action ->
        when (action) {
            IntroUIAction.OnLoginClick -> onLoginClick()
            IntroUIAction.OnRegisterClick -> onRegisterClick()
        }
    })
}

@Composable
fun IntroScreen(
    onAction: (IntroUIAction) -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .padding(bottom = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.app_icon),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
            }
            Text(
                text = stringResource(R.string.welcome_title),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(64.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PrimaryButton(
                    text = stringResource(R.string.sign_in),
                    onClick = {
                        onAction(IntroUIAction.OnLoginClick)
                    }
                )
                SecondaryButton(
                    text = stringResource(R.string.create_account),
                    onClick = {
                        onAction(IntroUIAction.OnRegisterClick)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    HabitsAppTheme {
        IntroScreen(
            onAction = {}
        )
    }
}