package com.roblesdotdev.habits.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.habits.presentation.overview.components.CurrentDate
import com.roblesdotdev.habits.presentation.overview.components.DateSelector
import com.roblesdotdev.habits.presentation.overview.components.OverviewCard
import com.roblesdotdev.habits.presentation.overview.components.OverviewTopAppBar

@Composable
fun OverviewScreenRoot(
    viewModel: OverviewViewModel = hiltViewModel(),
    onNavigateToSettings: () -> Unit
) {
    OverviewScreen(
        state = viewModel.state,
        onNavigateToSettings = onNavigateToSettings,
        onAction = { action ->
            when (action) {
                OverviewUIAction.NavigateToDetail -> onNavigateToSettings()
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun OverviewScreen(
    state: OverviewState,
    onAction: (OverviewUIAction) -> Unit,
    onNavigateToSettings: () -> Unit
) {
    Scaffold(
        topBar = {
            OverviewTopAppBar(
                onNavigationIconClick = onNavigateToSettings
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OverviewCard()
            Spacer(Modifier.height(8.dp))
            DateSelector(
                startDate = state.today,
                selectedDate = state.selectedDate,
                onChangeSelectedDate = {
                    onAction(OverviewUIAction.ChangeSelectedDate(it))
                }
            )
            CurrentDate(date = state.formattedCurrentDate)
        }
    }
}

@Preview
@Composable
private fun OverviewScreenPreview() {
    HabitsAppTheme {
        OverviewScreen(
            state = OverviewState(),
            onNavigateToSettings = {},
            onAction = {}
        )
    }
}