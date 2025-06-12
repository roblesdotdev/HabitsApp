package com.roblesdotdev.habitsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roblesdotdev.auth.presentation.intro.IntroScreenRoot
import com.roblesdotdev.auth.presentation.login.LoginScreenRoot
import com.roblesdotdev.auth.presentation.register.RegisterScreenRoot
import com.roblesdotdev.habits.presentation.overview.OverviewScreenRoot
import com.roblesdotdev.onboarding.presentation.OnboardingScreen

@Composable
fun DefaultNavigation(
    navController: NavHostController,
    isCompleteOnboarding: Boolean,
    isLoggedIn: Boolean,
) {
    val startDestination: Any = when {
        isLoggedIn -> NavRoute.Habits
        isCompleteOnboarding -> NavRoute.Auth
        else -> NavRoute.Onboarding
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        onboardingGraph(navController)
        authGraph(navController)
        habitsGraph(navController)
    }
}

private fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {
    navigation<NavRoute.Onboarding>(
        startDestination = NavRoute.Onboarding.Overview
    ) {
        composable<NavRoute.Onboarding.Overview> {
            OnboardingScreen(
                onCompleteOnboarding = {
                    navController.navigate(NavRoute.Auth) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<NavRoute.Auth>(
        startDestination = NavRoute.Auth.Intro
    ) {
        composable<NavRoute.Auth.Intro> {
            IntroScreenRoot(
                onLoginClick = {
                    navController.navigate(NavRoute.Auth.Login)
                },
                onRegisterClick = {
                    navController.navigate(NavRoute.Auth.Register)
                }
            )
        }

        composable<NavRoute.Auth.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(NavRoute.Habits) {
                        popUpTo(NavRoute.Auth) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(NavRoute.Auth.Register) {
                        popUpTo(NavRoute.Auth.Login) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }

        composable<NavRoute.Auth.Register> {
            RegisterScreenRoot(
                onLoginClick = {
                    navController.navigate(NavRoute.Auth.Login) {
                        popUpTo(NavRoute.Auth.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onRegisterSuccess = {
                    navController.navigate(NavRoute.Habits) {
                        popUpTo(NavRoute.Auth) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.habitsGraph(navController: NavHostController) {
    navigation<NavRoute.Habits>(
        startDestination = NavRoute.Habits.Overview
    ) {
        composable<NavRoute.Habits.Overview> {
            OverviewScreenRoot(
                onNavigateToSettings = {
                }
            )
        }
    }
}