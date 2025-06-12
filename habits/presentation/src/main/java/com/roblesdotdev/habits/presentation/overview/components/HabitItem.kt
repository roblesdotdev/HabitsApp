package com.roblesdotdev.habits.presentation.overview.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.domain.habit.Habit
import com.roblesdotdev.core.presentation.designsystem.components.CheckBox

@Composable
fun HabitItem(
    modifier: Modifier = Modifier,
    habit: Habit,
    onClick: () -> Unit,
    toggleComplete: () -> Unit,
) {
    Card(
        modifier = modifier.clickable {
            onClick()
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceBright
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    habit.category,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    habit.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            CheckBox(
                isChecked = false,
                onCheckedChange = {
                    toggleComplete()
                }
            )
        }
    }
}