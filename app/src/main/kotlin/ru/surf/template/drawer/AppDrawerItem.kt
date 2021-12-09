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
package ru.surf.template.drawer

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.surf.core.theme.MainAppTheme
import ru.surfstudio.compose.modifier.spaceMedium

/**
 * Application menu item
 *
 * @param label text on item
 * @param icon [ImageVector] on item
 * @param isSelected set enable or not
 * @param onClick callback click
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun AppDrawerItem(
    label: String,
    icon: ImageVector,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {
    val colors = MaterialTheme.colors

    val imageAlpha = if (isSelected) 1f else 0.6f

    val textColor = if (isSelected) {
        colors.primaryVariant
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }

    val bgColor = if (isSelected) {
        if (isSystemInDarkTheme()) colors.onSurface.copy(alpha = 0.7f) else colors.primaryVariant.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    Surface(
        modifier = Modifier
            .padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        color = bgColor,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    imageVector = icon,
                    contentDescription = label,
                    colorFilter = ColorFilter.tint(textColor),
                    alpha = imageAlpha
                )

                Spacer(modifier = Modifier.spaceMedium())

                Text(
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = textColor
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Column(
            Modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxSize()
        ) {
            AppDrawerItem(
                isSelected = true,
                label = "Settings",
                icon = Icons.Filled.Settings
            )
        }
    }
}
