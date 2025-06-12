package com.roblesdotdev.habits.presentation.overview.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.roblesdotdev.habits.presentation.R


@Composable
fun OverviewCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(160.dp)
            .clip(MaterialTheme.shapes.large)
            .paint(
                painterResource(R.drawable.overview_img),
                contentScale = ContentScale.FillBounds
            )
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        ) {
            Text(
                "Get More Focused",
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}