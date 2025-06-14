package com.roblesdotdev.habits.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.CheckBox
import java.time.DayOfWeek

@Composable
fun FrequencySelector(
    modifier: Modifier = Modifier,
    selectedDays: List<DayOfWeek>,
    onFrequencyChange: (DayOfWeek) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Frequency",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            ),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val days = DayOfWeek.entries.toTypedArray()
            days.forEach { dayOfWeek ->
                FrequencySelectorDate(
                    date = dayOfWeek,
                    isChecked = selectedDays.contains(dayOfWeek),
                    onCheckedChange = { onFrequencyChange(dayOfWeek) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.FrequencySelectorDate(
    modifier: Modifier = Modifier,
    date: DayOfWeek,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onCheckedChange() }
            .padding(vertical = 8.dp)
            .weight(1f)
    ) {
        Text(
            date.name.take(2), style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        )
        CheckBox(
            isChecked = isChecked,
            onCheckedChange = { onCheckedChange() },
            modifier = Modifier.size(20.dp)
        )
    }
}

@Preview
@Composable
private fun FrequencySelectorPreview() {
    HabitsAppTheme {
        Column(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background).padding(16.dp)
        ) {
            FrequencySelector(
                selectedDays = listOf(),
                onFrequencyChange = {}
            )
        }
    }

}