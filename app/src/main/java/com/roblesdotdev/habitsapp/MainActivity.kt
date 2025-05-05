package com.roblesdotdev.habitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.roblesdotdev.habitsapp.navigation.NavigationHost
import com.roblesdotdev.habitsapp.navigation.NavigationRoute
import com.roblesdotdev.habitsapp.ui.theme.HabitsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitsAppTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        NavigationHost(
            navHostController = navController,
            startDestination = NavigationRoute.Onboarding
        )
    }
}

@Preview
@Composable
private fun AppPreview() {
    HabitsAppTheme {
        App()
    }
}