package com.roblesdotdev.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerCount: Int,
    currentPage: Int,
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        repeat(pagerCount) { iteration ->
            val color = if (currentPage == iteration)
                MaterialTheme.colorScheme.tertiary
            else
                MaterialTheme.colorScheme.surfaceBright
            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(24.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(color)
                    .size(16.dp),
            )
        }
    }
}

@Preview
@Composable
private fun PagerIndicatorPreview() {
    HabitsAppTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            PagerIndicator(
                pagerCount = 3,
                currentPage = 1,
            )
        }
    }
}