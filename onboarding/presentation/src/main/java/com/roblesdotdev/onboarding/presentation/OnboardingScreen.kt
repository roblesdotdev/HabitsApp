package com.roblesdotdev.onboarding.presentation

import androidx.compose.runtime.Composable
import com.roblesdotdev.onboarding.presentation.components.OnboardingContent

@Composable
fun OnboardingScreen(
    onCompleteOnboarding: () -> Unit
) {
    OnboardingContent(
        pages = defaultOnboardingSteps,
        onCompleteOnboarding = onCompleteOnboarding
    )
}