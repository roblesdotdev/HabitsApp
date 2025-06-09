package com.roblesdotdev.auth.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.roblesdotdev.core.presentation.designsystem.CheckIcon
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTextField
import com.roblesdotdev.core.presentation.designsystem.success

@Composable
fun EmailTextField(
    enabled: Boolean = true,
    value: String,
    onValueChange: (String) -> Unit,
    isValidEmail: Boolean = false,
    placeholder: String? = null,
) {
    DefaultTextField(
        enabled = enabled,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        trailingIcon = {
            Icon(
                CheckIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.success.copy(
                    alpha = if (isValidEmail) 1f else 0f
                )
            )
        }
    )
}