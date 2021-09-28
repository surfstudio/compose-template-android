/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.extension

import androidx.compose.ui.graphics.Color

/**
 * Parse string color to [Color]
 *
 * @author Vitaliy Zarubin
 */
fun String.parseColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}
