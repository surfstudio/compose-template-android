package ru.surf.core.extension

import androidx.compose.ui.graphics.Color

fun String.parseColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}