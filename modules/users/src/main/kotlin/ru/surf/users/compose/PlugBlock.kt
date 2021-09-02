package ru.surf.users.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.surf.users.R

@Composable
fun PlugBlock(
    title: String? = null,
    text: String? = null,
    painter: Painter = painterResource(id = R.drawable.ic_common_not_found),
    contentBoxScope: @Composable BoxScope.() -> Unit = {},
    contentColumnScope: @Composable ColumnScope.() -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .size(248.dp)
                        .align(Alignment.Center)
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        painter = painter,
                        contentDescription = null)
                }
            }

            title?.let {
                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = title.uppercase(),
                    style = MaterialTheme.typography.h5,
                )
            } ?: run {
                Spacer(modifier = Modifier.size(16.dp))
            }

            text?.let {
                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    text = text,
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            contentColumnScope.invoke(this)
        }

        contentBoxScope.invoke(this)
    }
}