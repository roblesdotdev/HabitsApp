package com.roblesdotdev.habitsapp.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoute {
    @Serializable
    data object Onboarding {
        @Serializable
        data object Overview : NavRoute
    }

    @Serializable
    data object Auth {
        @Serializable
        data object Intro: NavRoute

        @Serializable
        data object Login: NavRoute

        @Serializable
        data object Register: NavRoute
    }

    @Serializable
    data object Habits {
        @Serializable
        data object Overview: NavRoute
    }
}