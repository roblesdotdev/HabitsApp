package com.roblesdotdev.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.onboarding.presentation.components.OnboardingContent

@Composable
fun OnboardingScreen(
    onCompleteOnboarding: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    OnboardingContent(
        pages = defaultOnboardingSteps,
        onCompleteOnboarding = onCompleteOnboarding,
        onAction = viewModel::onAction
    )
}