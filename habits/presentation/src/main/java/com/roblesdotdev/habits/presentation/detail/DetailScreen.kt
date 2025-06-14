package com.roblesdotdev.habits.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTextField
import com.roblesdotdev.core.presentation.designsystem.components.PrimaryButton
import com.roblesdotdev.habits.presentation.R
import com.roblesdotdev.habits.presentation.detail.components.CategorySelector
import com.roblesdotdev.habits.presentation.detail.components.DetailTopAppBar
import com.roblesdotdev.habits.presentation.detail.components.FrequencySelector
import com.roblesdotdev.habits.presentation.detail.components.ReminderSelector

@Composable
fun DetailScreenRoot(
    viewModel: DetailViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    isEditMode: Boolean,
) {
    DetailScreen(
        state = viewModel.state,
        isEditMode = isEditMode,
        onAction = { action ->
            when (action) {
                DetailUIAction.NavigateBack -> onNavigateBack()
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun DetailScreen(
    onAction: (DetailUIAction) -> Unit,
    state: DetailUIState,
    isEditMode: Boolean,
) {
    Scaffold(
        topBar = {
            DetailTopAppBar(isEditMode, onAction)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultTextField(
                value = state.name,
                onValueChange = {
                    onAction(DetailUIAction.ChangeName(it))
                },
                placeholder = stringResource(R.string.habit_name_placeholder)
            )
            CategorySelector(
                value = state.category,
                onValueChange = {
                    onAction(DetailUIAction.ChangeCategory(it))
                }
            )
            FrequencySelector(
                selectedDays = state.frequency,
                onFrequencyChange = { onAction(DetailUIAction.ToggleFrequencyDay(it)) }
            )
            ReminderSelector(
                value = state.reminder,
                onValueChange = {
                    onAction(DetailUIAction.ChangeReminder(it))
                }
            )
            Spacer(Modifier.weight(1f))
            PrimaryButton(onClick = {}, text = "Save")
        }
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    HabitsAppTheme {
        DetailScreen(
            onAction = {},
            isEditMode = false,
            state = DetailUIState()
        )
    }
}

