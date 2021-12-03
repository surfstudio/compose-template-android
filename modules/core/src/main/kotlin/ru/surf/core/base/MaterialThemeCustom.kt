/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.core.base

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import ru.surf.core.base.LocalMaterialThemeCustom.colors
import ru.surf.core.base.LocalMaterialThemeCustom.shapes
import ru.surf.core.base.LocalMaterialThemeCustom.typography

/**
 * Static object for [MaterialThemeCustom]
 *
 * @property colors custom colors [ColorsCustom]
 * @property typography custom typography [TypographyCustom]
 * @property shapes custom shapes [ShapesCustom]
 *
 * @author Vitaliy Zarubin
 */
object LocalMaterialThemeCustom {
    var colors: ColorsCustom? = null
    var typography: TypographyCustom? = null
    var shapes: ShapesCustom? = null
}

/**
 * fun for generate [MaterialThemeCustom]
 *
 * @property colors custom colors [ColorsCustom], required
 * @property typography custom typography [TypographyCustom], optional
 * @property shapes custom shapes [ShapesCustom], optional
 *
 * @author Vitaliy Zarubin
 */
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
