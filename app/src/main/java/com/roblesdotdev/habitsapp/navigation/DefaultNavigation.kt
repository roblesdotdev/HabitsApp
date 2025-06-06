package com.roblesdotdev.habitsapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roblesdotdev.auth.presentation.intro.IntroScreen
import com.roblesdotdev.onboarding.presentation.OnboardingScreen

@Composable
fun DefaultNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Onboarding,
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
        composable<NavRoute.Onboarding.Overview>{
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
            IntroScreen(
                onLoginClick = {
                    navController.navigate(NavRoute.Auth.Login)
                },
                onRegisterClick = {
                    navController.navigate(NavRoute.Auth.Register)
                }
            )
        }

        composable<NavRoute.Auth.Login> {
            Text("Login")
        }

        composable<NavRoute.Auth.Register> {
            Text("Register")
        }
    }
}

private fun NavGraphBuilder.habitsGraph(navController: NavHostController) {
    navigation<NavRoute.Habits>(
        startDestination = NavRoute.Habits.Overview
    ) {
        composable<NavRoute.Habits.Overview> {  }
    }
}