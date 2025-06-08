package com.roblesdotdev.onboarding.domain.usecase

import com.roblesdotdev.core.domain.preferences.UserPreferences

class CompleteOnboardingUseCase(
    private val preferences: UserPreferences
) {
    suspend operator fun invoke() {
       preferences.completeOnboarding()
    }
}