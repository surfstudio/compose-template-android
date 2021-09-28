/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import ru.surf.core.R
import ru.surf.core.base.ColorsCustom
import ru.surf.core.data.models.SettingsModel

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
