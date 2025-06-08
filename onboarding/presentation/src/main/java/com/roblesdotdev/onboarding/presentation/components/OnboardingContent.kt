package com.roblesdotdev.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.components.PrimaryButton
import com.roblesdotdev.core.presentation.designsystem.components.SecondaryButton
import com.roblesdotdev.onboarding.presentation.OnboardingStep
import com.roblesdotdev.onboarding.presentation.defaultOnboardingSteps
import kotlinx.coroutines.launch

@Composable
fun OnboardingContent(
    modifier: Modifier = Modifier,
    pages: List<OnboardingStep>,
    onCompleteOnboarding: () -> Unit,
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.dp)
            .padding(bottom = 72.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { pageIndex ->
            val currentPage = pages[pageIndex]
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(Modifier.height(48.dp))
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(currentPage.image),
                        contentDescription = null,
                        modifier = Modifier.size(220.dp)
                    )
                }
                Text(
                    text = stringResource(currentPage.title),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = stringResource(currentPage.description),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
        Spacer(Modifier.height(48.dp))
        PagerIndicator(
            pagerCount = pagerState.pageCount,
            currentPage = pagerState.currentPage
        )
        Spacer(Modifier.height(72.dp))

        if (pagerState.currentPage == pages.lastIndex) {
            PrimaryButton(onClick = onCompleteOnboarding, text = "Get Started")
        } else {
            SecondaryButton(onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }, text = "Continue")
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    HabitsAppTheme {
        Surface {
            OnboardingContent(
                pages = defaultOnboardingSteps,
                onCompleteOnboarding = {}
            )
        }
    }
}