package com.roblesdotdev.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.roblesdotdev.core.presentation.designsystem.success

@Composable
fun OnboardingScreen(
    onCompleteOnboarding: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        TextButton(onClick = onCompleteOnboarding) {
            Text("Get started", color = MaterialTheme.colorScheme.success)
        }
    }
}