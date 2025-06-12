package com.roblesdotdev.habits.presentation.overview.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.roblesdotdev.core.presentation.designsystem.SettingsIcon
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTopAppBar
import com.roblesdotdev.habits.presentation.R

@Composable
fun OverviewTopAppBar(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit
) {
    DefaultTopAppBar(
        modifier = modifier,
        title = stringResource(R.string.habits_overview_title),
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    SettingsIcon,
                    contentDescription = stringResource(R.string.settings)
                )
            }
        }
    )
}