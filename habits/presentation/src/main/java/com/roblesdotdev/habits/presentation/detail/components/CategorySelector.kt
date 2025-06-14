package com.roblesdotdev.habits.presentation.detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.FieldSelector
import com.roblesdotdev.habits.presentation.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySelector(
    value: String,
    onValueChange: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    FieldSelector(
        value = value,
        placeholder = stringResource(R.string.habit_category_placeholder),
        onClick = {
            showSheet = true
        },
    )

    if (showSheet) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = {
                showSheet = false
            }
        ) {
            CategoryList(onSelect = { category ->
                coroutineScope.launch {
                    bottomSheetState.hide()
                    showSheet = false
                    onValueChange(category)
                }
            })
        }
    }
}

@Composable
private fun CategoryList(
    modifier: Modifier = Modifier,
    onSelect: (String) -> Unit,
) {
    val categories = listOf(
        "Personal Growth",
        "Organization",
        "Health",
        "Training",
        "Study",
        "Work",
        "Entertainment",
        "Other"
    )
    LazyVerticalGrid(
        modifier = modifier.padding(top = 16.dp, bottom = 24.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(categories) { category ->
            TextButton(
                onClick = {
                    onSelect(category)
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            ) {
                Text(category)
            }
        }
    }
}

@Preview
@Composable
private fun CategoryListPreview() {
    HabitsAppTheme {
        CategoryList(
            onSelect = {}
        )
    }
}