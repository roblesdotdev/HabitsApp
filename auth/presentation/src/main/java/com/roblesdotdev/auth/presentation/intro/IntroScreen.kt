package com.roblesdotdev.auth.presentation.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun IntroScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)  {
        Column {

        Text("Auth Intro")
            TextButton(onClick = onLoginClick) {
                Text("Login")
            }
            TextButton(onClick = onRegisterClick) {
                Text("Register")
            }
        }
    }
}