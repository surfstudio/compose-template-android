/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.surf.core.R
import ru.surf.core.base.TypographyCustom

/**
 * Custom [FontFamily] from resources
 *
 * @author Vitaliy Zarubin
 */
val montserratFamily = FontFamily(
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold)
)

/**
 * System Typography
 *
 * @author Vitaliy Zarubin
 */
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

/**
 * Custom Typography
 *
 * @author Vitaliy Zarubin
 */
val TypographyCustom = TypographyCustom(
    title = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    )
)
