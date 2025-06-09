package com.roblesdotdev.auth.presentation.components

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme

@Composable
fun AnnotatedClickableText(
    modifier: Modifier = Modifier,
    normalText: String,
    clickableText: String,
    onClick: () -> Unit,
) {
    var layoutResult by remember { mutableStateOf<TextLayoutResult?>(null) }

    val annotatedText = buildAnnotatedString {
       append(normalText)
       append(" ")
       pushStringAnnotation(
           tag = "ACTION",
           annotation = "click"
       )
       withStyle(
           style = SpanStyle(
               fontSize = MaterialTheme.typography.bodyMedium.fontSize,
               color = MaterialTheme.colorScheme.onBackground,
               fontWeight = FontWeight.Medium
           )
       ) {
           append(clickableText)
       }
       pop()
   }
    Text(
        text = annotatedText,
        style = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        ),
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures { tapOffset ->
                layoutResult?.let { layout ->
                    val position = layout.getOffsetForPosition(tapOffset)
                    annotatedText.getStringAnnotations("ACTION", position, position)
                        .firstOrNull()?.let {
                            onClick()
                        }
                }
            }
        },
        onTextLayout = { layoutResult = it }
    )
}

@Preview
@Composable
private fun AnnotatedClickableTextPreview() {
    HabitsAppTheme {
        Surface(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            AnnotatedClickableText(
                normalText = "Have an account?",
                clickableText = "Sign in",
                onClick = {}
            )
        }
    }
}