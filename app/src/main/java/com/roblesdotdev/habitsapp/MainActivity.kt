package com.roblesdotdev.habitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.habitsapp.navigation.DefaultNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HabitsAppTheme {
                DefaultNavigation(navController = navController)
            }
        }
    }
}