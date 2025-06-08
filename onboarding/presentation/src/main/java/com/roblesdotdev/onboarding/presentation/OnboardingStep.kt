package com.roblesdotdev.onboarding.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingStep(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int,
)

val defaultOnboardingSteps = listOf(
    OnboardingStep(
        title = R.string.onboarding1_title,
        description = R.string.onboarding1_desc,
        image = R.drawable.onboarding1_img,
    ),
    OnboardingStep(
        title = R.string.onboarding2_title,
        description = R.string.onboarding2_desc,
        image = R.drawable.ongoarding2_img,
    ),
    OnboardingStep(
        title = R.string.onboarding3_title,
        description = R.string.onboarding3_desc,
        image = R.drawable.onboarding3_img,
    )
)