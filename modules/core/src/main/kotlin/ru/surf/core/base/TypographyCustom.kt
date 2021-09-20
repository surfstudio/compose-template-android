package ru.surf.core.base

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

class TypographyCustom(
    val title: TextStyle,
) {
    companion object {
        val default: @Composable () -> TypographyCustom by lazy {
            { TypographyCustom(title = MaterialTheme.typography.h1) }
        }
    }
}