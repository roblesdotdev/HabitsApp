package com.roblesdotdev.auth.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTextField

@Composable
fun EmailTextField(
    enabled: Boolean = true,
    value: String,
    onValueChange: (String) -> Unit,
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
    )
}