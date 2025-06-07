package com.roblesdotdev.core.presentation.designsystem

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    background = background,
    surface = surface,
    surfaceBright = surfaceBright,
    primary = primary,
    tertiary = tertiary,
    onBackground = onBackground,
    onPrimary = onPrimary,
    onSurface = onSurface,
    onSurfaceVariant = onSurfaceVariant,
    surfaceContainer = surfaceContainer,
    error = error,
)

val ColorScheme.success: Color
    @Composable get() = successContent

val ColorScheme.neutral10: Color
    @Composable get() = neutral10Container

val ColorScheme.neutral50: Color
    @Composable get() = neutral50Container

@Composable
fun HabitsAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
