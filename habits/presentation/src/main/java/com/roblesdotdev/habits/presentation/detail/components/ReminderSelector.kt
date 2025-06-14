package com.roblesdotdev.habits.presentation.detail.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.roblesdotdev.core.presentation.designsystem.components.FieldSelector
import com.roblesdotdev.habits.presentation.R
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderSelector(
    value: LocalTime,
    onValueChange: (LocalTime) -> Unit
) {
    var showPicker by remember { mutableStateOf(false) }
    val timerPickerState = rememberTimePickerState(
        initialHour = value.hour,
        initialMinute = value.minute,
        is24Hour = true
    )
    FieldSelector(
        value = value.toString(),
        placeholder = stringResource(R.string.reminder),
        onClick = {
            showPicker = true
        }
    )

    if (showPicker) {
        TimePickerDialog(
            onDismiss = {
                showPicker = false
            },
            onConfirm = {
                showPicker = false
                onValueChange(LocalTime.of(timerPickerState.hour, timerPickerState.minute))
            }
        ) {
            TimeInput(
                state = timerPickerState,
                colors = TimePickerDefaults.colors(
                    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    timeSelectorSelectedContainerColor = MaterialTheme.colorScheme.surfaceBright,
                    periodSelectorBorderColor = MaterialTheme.colorScheme.tertiary.copy(
                        alpha = 0.2f
                    ),
                    timeSelectorUnselectedContainerColor = MaterialTheme.colorScheme.surfaceBright,
                    periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    }
}

@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        containerColor = MaterialTheme.colorScheme.background,
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Dismiss", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        },
        title = { Text(stringResource(R.string.select_time))},
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("OK", color = MaterialTheme.colorScheme.tertiary)
            }
        },
        text = { content() }
    )
}
