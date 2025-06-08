package com.roblesdotdev.habitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.habitsapp.navigation.DefaultNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.state.isLoading
            }
        }
        setContent {
            val navController = rememberNavController()
            HabitsAppTheme {
                if (!mainViewModel.state.isLoading) {
                    DefaultNavigation(
                        navController = navController,
                        isCompleteOnboarding = mainViewModel.state.isCompleteOnboarding
                    )
                }
            }
        }
    }
}