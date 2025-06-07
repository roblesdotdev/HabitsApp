package com.roblesdotdev.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.neutral10
import com.roblesdotdev.core.presentation.designsystem.neutral50

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.surfaceBright,
            disabledContentColor = MaterialTheme.colorScheme.neutral50,
            disabledContainerColor = MaterialTheme.colorScheme.neutral10,
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            textDecoration = if (enabled) TextDecoration.None else TextDecoration.LineThrough
        )
    }
}

@Preview
@Composable
private fun SecondaryButtonPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
          SecondaryButton(
                onClick = {},
                text = "Continue"
            )
        }
    }
}

@Preview
@Composable
private fun SecondaryButtonDisabledPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            SecondaryButton(
                onClick = {},
                text = "Continue",
                enabled = false,
            )
        }
    }
}
