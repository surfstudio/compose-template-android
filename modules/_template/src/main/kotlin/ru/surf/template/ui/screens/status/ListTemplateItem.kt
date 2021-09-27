/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.ui.screens.status

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.ui.actions.ListTemplateActions

@Composable
// This screen is an example of fragmentation.
// @todo {ScreenName}{CustomName}
fun ListTemplateItem(
    model: TemplateModel,
    onActions: (ListTemplateActions) -> Unit = {},
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable {
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 9.dp, bottom = 12.dp, start = 12.dp, end = 6.dp)
        ) {
            Text(
                text = model.name.uppercase(),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
