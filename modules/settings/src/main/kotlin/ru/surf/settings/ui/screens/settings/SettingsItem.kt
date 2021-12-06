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
package ru.surf.settings.ui.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.surfstudio.compose.modifier.spaceMedium

/**
 * Item list for page [SettingsBody]
 *
 * @param text string name item
 * @param onClick callback click item
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SettingsItem(
    text: String,
    onClick: () -> Unit = {},
) {
    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        ConstraintLayout(
            modifier = Modifier.spaceMedium()
        ) {
            val (vText, icon) = createRefs()

            Text(
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1,
                text = text,
                modifier = Modifier
                    .defaultMinSize(minWidth = 100.dp)
                    .constrainAs(vText) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null,
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .height(12.dp)
                    .constrainAs(icon) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}
