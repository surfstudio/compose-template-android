/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.keygenqt.accompanist.MainScaffoldSearch

/**
 * Text for contentTitle [MainScaffoldSearch]
 *
 * @param text string with text
 * @param textAlign align text, default [TextAlign.Left]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun TopBarContentTitle(
    text: String,
    textAlign: TextAlign = TextAlign.Left
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        fontSize = TextUnit.Unspecified,
        text = text,
        textAlign = textAlign,
        color = MaterialTheme.colors.onPrimary
    )
}
