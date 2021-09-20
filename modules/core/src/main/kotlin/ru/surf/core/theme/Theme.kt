package ru.surf.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ru.surf.core.base.ColorsCustom
import ru.surf.core.base.MaterialThemeCustom

// custom palette colors
val DarkColorCustomPalette: @Composable () -> ColorsCustom by lazy {
    { parseConfigCustomPalette(false) }
}

val LightColorCustomPalette: @Composable () -> ColorsCustom by lazy {
    { parseConfigCustomPalette(true) }
}

// system palette colors
val DarkColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(false) }
}

val LightColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(true) }
}

@Composable
fun MainAppTheme(content: @Composable() () -> Unit) {

    val colorsCustom = if (isSystemInDarkTheme()) {
        DarkColorCustomPalette.invoke()
    } else {
        LightColorCustomPalette.invoke()
    }

    val colors = if (isSystemInDarkTheme()) {
        DarkColorPalette.invoke()
    } else {
        LightColorPalette.invoke()
    }

    MaterialThemeCustom(
        colors = colorsCustom,
        typography = TypographyCustom,
        shapes = ShapesCustom,
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}