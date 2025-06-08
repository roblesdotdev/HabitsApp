package com.roblesdotdev.auth.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.auth.presentation.R
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes subtitle: Int,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            stringResource(subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview
@Composable
private fun SectionHeaderPreview() {
    HabitsAppTheme {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            SectionHeader(
                title = R.string.login_title,
                subtitle = R.string.login_subtitle
            )
        }
    }
}