package com.roblesdotdev.onboarding.presentation

sealed interface OnboardingAction {
    data object CompleteOnboarding: OnboardingAction
}