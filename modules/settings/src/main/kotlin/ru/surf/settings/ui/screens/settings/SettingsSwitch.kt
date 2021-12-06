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
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.surfstudio.compose.modifier.spaceMedium

/**
 * Item list for page [SettingsBody]
 *
 * @param text string name item
 * @param checked start state switch
 * @param onCheckedChange callback click item and change state switch
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SettingsSwitch(
    text: String,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    var checkedState: Boolean by remember { mutableStateOf(checked) }

    Card(
        shape = MaterialTheme.shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                checkedState = !checkedState
                onCheckedChange(checkedState)
            })
    ) {
        ConstraintLayout(
            modifier = Modifier.spaceMedium()
        ) {
            val (vText, switch) = createRefs()

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
            Switch(
                checked = checkedState,
                onCheckedChange = {
                    checkedState = !checkedState
                    onCheckedChange.invoke(checked)
                },
                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.secondary),
                modifier = Modifier
                    .constrainAs(switch) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}
