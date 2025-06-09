package com.roblesdotdev.auth.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.roblesdotdev.core.presentation.designsystem.EyeClosedIcon
import com.roblesdotdev.core.presentation.designsystem.EyeOpenIcon
import com.roblesdotdev.core.presentation.designsystem.components.DefaultTextField

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    placeholder: String? = null,
    showPassword: Boolean = false,
    onToggleShowPassword: () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    DefaultTextField(
        enabled = enabled,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = {
            IconButton(onClick = {
                onToggleShowPassword()
            }) {
                val icon = if (!showPassword) EyeClosedIcon else EyeOpenIcon
                Icon(
                    icon, contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    )
}