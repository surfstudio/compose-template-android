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
package ru.surf.core.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import ru.surfstudio.compose.accompanist.MainScaffoldSearch

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
