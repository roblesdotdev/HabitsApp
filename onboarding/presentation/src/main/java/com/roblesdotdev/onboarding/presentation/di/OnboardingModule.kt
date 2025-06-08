package com.roblesdotdev.onboarding.presentation.di

import com.roblesdotdev.core.domain.preferences.UserPreferences
import com.roblesdotdev.onboarding.domain.usecase.CompleteOnboardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {
    @Singleton
    @Provides
    fun provideCompleteOnboardingUseCase(
        preferences: UserPreferences
    ): CompleteOnboardingUseCase {
        return CompleteOnboardingUseCase(preferences)
    }
}