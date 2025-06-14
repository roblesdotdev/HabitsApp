package com.roblesdotdev.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.HabitsAppTheme
import com.roblesdotdev.core.presentation.designsystem.neutral10

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    errorMessage: String? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String? = null,
    focusRequester: FocusRequester = FocusRequester(),
    trailingIcon: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
) {

    val placeholderComposable: (@Composable () -> Unit)? = placeholder?.let {
        @Composable {
            Text(text = placeholder, style = MaterialTheme.typography.bodyMedium)
        }
    }

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholderComposable,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            isError = errorMessage != null,
            visualTransformation = visualTransformation,
            shape = MaterialTheme.shapes.large,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                disabledBorderColor = MaterialTheme.colorScheme.neutral10,
            ),
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            enabled = enabled,
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .focusRequester(focusRequester),
        )

        if (errorMessage != null) {
            Text(
                errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = 16.dp
                )
            )
        }
    }
}

@Preview
@Composable
private fun DefaultTextFieldPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "",
                onValueChange = {},
                placeholder = "Enter your email"
            )
        }
    }

}

@Preview
@Composable
private fun DefaultTextFieldFilledPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "demo@email.com",
                onValueChange = {},
                placeholder = "Enter your email"
            )
        }
    }

}


@Preview
@Composable
private fun DefaultTextFieldTrailingPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "",
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                },
                onValueChange = {},
                placeholder = "Enter your email"
            )
        }
    }

}

@Preview
@Composable
private fun DefaultTextFieldDisabledPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "demo@email.com",
                onValueChange = {},
                placeholder = "Enter your email",
                enabled = false,
            )
        }
    }

}

@Preview
@Composable
private fun DefaultTextFieldErrorPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "demo@email.com",
                onValueChange = {},
                errorMessage = "Email already taken",
                placeholder = "Enter your email",
            )
        }
    }

}

@Preview
@Composable
private fun DefaultTextFieldPasswordPreview() {
    HabitsAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            DefaultTextField(
                value = "my password",
                visualTransformation = PasswordVisualTransformation(
                ),
                onValueChange = {},
                placeholder = "Enter your email",
            )
        }
    }

}
