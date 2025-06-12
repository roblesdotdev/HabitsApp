package com.roblesdotdev.habits.presentation.overview.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import java.time.ZonedDateTime

@Composable
fun DateSelector(
    modifier: Modifier = Modifier,
    selectedDate: ZonedDateTime,
    onChangeSelectedDate: (ZonedDateTime) -> Unit,
    startDate: ZonedDateTime
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(7) { index ->
            val date = startDate.minusDays(index.toLong())
            DateSelectorItem(
                date = date,
                isSelected = selectedDate.toLocalDate() == date.toLocalDate(),
                onClick = {
                    onChangeSelectedDate(date)
                }
            )
        }
    }
}

@Composable
fun RowScope.DateSelectorItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    date: ZonedDateTime,
    onClick: () -> Unit,
) {
    val containerColor =
        if (isSelected) MaterialTheme.colorScheme.surfaceBright else
            MaterialTheme.colorScheme.surface
    val contentColor = if (isSelected) MaterialTheme.colorScheme.onSurface else
        MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = modifier
            .clickable { onClick() }
            .weight(1f)
            .clip(MaterialTheme.shapes.small)
            .background(containerColor),
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(24.dp)
                    .height(2.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .align(Alignment.TopCenter),
            ) {}
        }
        Column(
            modifier = Modifier.padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = date.dayOfWeek.name.take(1),
                style = MaterialTheme.typography.bodySmall,
                color = contentColor,
            )
            Text(
                text = date.dayOfMonth.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = contentColor,
            )
        }
    }
}