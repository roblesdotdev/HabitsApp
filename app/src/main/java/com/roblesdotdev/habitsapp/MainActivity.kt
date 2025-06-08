package com.roblesdotdev.habitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.habitsapp.navigation.DefaultNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val mainViewModel by viewModels<MainViewModel>()
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