package com.roblesdotdev.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.CheckIcon
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.neutral10

@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: () -> Unit
) {
    val containerColor = if (isChecked) MaterialTheme.colorScheme.primary else
        MaterialTheme.colorScheme.neutral10
    Box(
        modifier = Modifier
            .clickable { onCheckedChange() }
            .size(32.dp)
            .clip(MaterialTheme.shapes.small)
            .background(containerColor)
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        if (isChecked) {
            Icon(
                CheckIcon,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Preview
@Composable
private fun CheckBoxPreview() {
    HabitsAppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CheckBox(isChecked = false, onCheckedChange = {})
            CheckBox(isChecked = true, onCheckedChange = {})
        }
    }

}