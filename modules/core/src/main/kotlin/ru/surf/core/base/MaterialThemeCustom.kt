/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object LocalMaterialThemeCustom {
    var colors: ColorsCustom? = null
    var typography: TypographyCustom? = null
    var shapes: ShapesCustom? = null
}

@Composable
fun MaterialThemeCustom(
    colors: ColorsCustom = LocalMaterialThemeCustom.colors!!,
    typography: TypographyCustom = TypographyCustom.default.invoke(),
    shapes: ShapesCustom = ShapesCustom.default,
) {
    LocalMaterialThemeCustom.colors = colors
    LocalMaterialThemeCustom.typography = typography
    LocalMaterialThemeCustom.shapes = shapes
}

/**
 * Material Theme Custom
 *
 * @author Vitaliy Zarubin
 */
object MaterialThemeCustom {
    /**
     * Retrieves the current [Colors] at the call site's position in the hierarchy.
     *
     * @sample androidx.compose.material.samples.ThemeColorSample
     */
    val colors: ColorsCustom
        @Composable
        @ReadOnlyComposable
        get() {
            return if (LocalMaterialThemeCustom.colors == null) {
                throw RuntimeException("You must initialize MaterialThemeCustom colors")
            } else {
                LocalMaterialThemeCustom.colors!!
            }
        }

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     *
     * @sample androidx.compose.material.samples.ThemeTextStyleSample
     */
    val typography: TypographyCustom
        @Composable
        @ReadOnlyComposable
        get() {
            return if (LocalMaterialThemeCustom.typography == null) {
                throw RuntimeException("You must initialize MaterialThemeCustom typography")
            } else {
                LocalMaterialThemeCustom.typography!!
            }
        }

    /**
     * Retrieves the current [Shapes] at the call site's position in the hierarchy.
     */
    val shapes: ShapesCustom
        @Composable
        @ReadOnlyComposable
        get() = LocalMaterialThemeCustom.shapes ?: ShapesCustom.default
}
