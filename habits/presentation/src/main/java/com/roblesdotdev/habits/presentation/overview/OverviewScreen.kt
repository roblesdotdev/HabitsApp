package com.roblesdotdev.habits.presentation.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.PlusIcon
import com.roblesdotdev.habits.presentation.R
import com.roblesdotdev.habits.presentation.overview.components.CurrentDate
import com.roblesdotdev.habits.presentation.overview.components.DateSelector
import com.roblesdotdev.habits.presentation.overview.components.HabitItem
import com.roblesdotdev.habits.presentation.overview.components.OverviewCard
import com.roblesdotdev.habits.presentation.overview.components.OverviewTopAppBar

@Composable
fun OverviewScreenRoot(
    viewModel: OverviewViewModel = hiltViewModel(),
    onNavigateToSettings: () -> Unit,
    onNavigateToDetail: (String?) -> Unit,
) {
    OverviewScreen(
        state = viewModel.state,
        onNavigateToSettings = onNavigateToSettings,
        onAction = { action ->
            when (action) {
                OverviewUIAction.NavigateToSettings -> onNavigateToSettings()
                is OverviewUIAction.NavigateToDetail -> onNavigateToDetail(action.id)
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAction(OverviewUIAction.NavigateToDetail(null))
                },
                containerColor = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(56.dp)
            ) {
                Icon(PlusIcon, contentDescription = stringResource(R.string.add_habit))
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                OverviewCard()
            }
            stickyHeader {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(top = 8.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CurrentDate(date = state.formattedCurrentDate)
                    DateSelector(
                        startDate = state.today,
                        selectedDate = state.selectedDate,
                        onChangeSelectedDate = {
                            onAction(OverviewUIAction.ChangeSelectedDate(it))
                        }
                    )
                }
            }
            items(
                state.habits,
            ) { habit ->
                HabitItem(
                    habit = habit,
                    onClick = {
                        onAction(OverviewUIAction.NavigateToDetail(habit.id))
                    },
                    selectedDate = state.selectedDate.toLocalDate(),
                    toggleComplete = {
                        onAction(
                            OverviewUIAction.ToggleComplete(
                                habit = habit,
                            )
                        )
                    }
                )
            }

            item {
                Spacer(Modifier.height(56.dp))
            }
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