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
package ru.surf.core.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import ru.surf.core.R
import ru.surf.core.base.ColorsCustom

/**
 * Parse colors from xml [ColorsCustom]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun parseConfigCustomPalette(isLight: Boolean): ColorsCustom {
    return ColorsCustom(
        link = colorResource(R.color.link),
        linkAction = colorResource(R.color.linkAction),
        isLight = isLight
    )
}

/**
 * Parse colors from xml [Colors]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun parseConfigPalette(isLight: Boolean): Colors {
    return Colors(
        primary = colorResource(R.color.primary),
        primaryVariant = colorResource(R.color.primaryVariant),
        secondary = colorResource(R.color.secondary),
        secondaryVariant = colorResource(R.color.secondaryVariant),
        background = colorResource(R.color.background),
        surface = colorResource(R.color.surface),
        error = colorResource(R.color.error),
        onPrimary = colorResource(R.color.onPrimary),
        onSecondary = colorResource(R.color.onSecondary),
        onBackground = colorResource(R.color.onBackground),
        onSurface = colorResource(R.color.onSurface),
        onError = colorResource(R.color.onError),
        isLight = isLight,
    )
}
