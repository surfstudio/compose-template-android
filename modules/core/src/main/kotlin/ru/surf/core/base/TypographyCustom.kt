/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

/**
 * Typography custom for [MaterialThemeCustom]
 *
 * @property title typography for title, example
 *
 * @author Vitaliy Zarubin
 */
class TypographyCustom(
    val title: TextStyle,
) {
    companion object {
        val default: @Composable () -> TypographyCustom by lazy {
            { TypographyCustom(title = MaterialTheme.typography.h1) }
        }
    }
}
