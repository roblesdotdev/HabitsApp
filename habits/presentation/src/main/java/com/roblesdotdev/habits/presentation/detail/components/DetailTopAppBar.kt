package com.roblesdotdev.habits.presentation.detail.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.roblesdotdev.core.presentation.designsystem.ArrowLeftIcon
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTopAppBar
import com.roblesdotdev.habits.presentation.R
import com.roblesdotdev.habits.presentation.detail.DetailUIAction

@Composable
fun DetailTopAppBar(
    isEditMode: Boolean,
    onAction: (DetailUIAction) -> Unit
) {
    DefaultTopAppBar(
        title = if (isEditMode) {
            stringResource(R.string.edit_habit)
        } else {
            stringResource(R.string.new_habit)
        },
        navigationIcon = {
            IconButton(onClick = {
                onAction(DetailUIAction.NavigateBack)
            }) {
                Icon(ArrowLeftIcon, contentDescription = stringResource(R.string.back))
            }
        }
    )
}
