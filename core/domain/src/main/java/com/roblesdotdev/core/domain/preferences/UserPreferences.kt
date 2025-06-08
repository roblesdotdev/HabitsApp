package com.roblesdotdev.core.domain.preferences

interface UserPreferences {
    suspend fun isCompleteOnboarding(): Boolean
    suspend fun completeOnboarding()

    companion object {
        const val KEY_COMPLETE_ONBOARDING = "complete_onboarding"
    }
}