/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

/**
 * Shapes custom for [MaterialThemeCustom]
 *
 * @property listItem for lists [RoundedCornerShape]
 *
 * @author Vitaliy Zarubin
 */
class ShapesCustom(
    val listItem: CornerBasedShape = RoundedCornerShape(8.dp),
) {
    companion object {
        val default by lazy { ShapesCustom() }
    }
}
