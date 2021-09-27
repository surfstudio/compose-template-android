/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import ru.surf.core.base.ShapesCustom

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val ShapesCustom = ShapesCustom(
    listItem = RoundedCornerShape(8.dp)
)
