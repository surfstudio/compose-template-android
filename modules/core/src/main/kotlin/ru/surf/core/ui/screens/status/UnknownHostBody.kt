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
package ru.surf.core.ui.screens.status

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.google.accompanist.insets.navigationBarsWithImePadding
import ru.surf.core.R
import ru.surf.core.theme.MainAppTheme
import ru.surf.core.ui.actions.UnknownHostActions
import ru.surfstudio.compose.modifier.spacePage

/**
 * Page animation for [UnknownHostBody]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun UnknownHostAnimation(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error_network))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = modifier
    )
}

@Composable
fun UnknownHostBody(
    loading: Boolean = false,
    onActions: (UnknownHostActions) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .spacePage()
            .navigationBarsWithImePadding()
    ) {
        Box(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                style = MaterialTheme.typography.h6,
                text = stringResource(id = R.string.unknown_host_text)
            )
        }
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxSize()
        ) {
            UnknownHostAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            } else {
                Button(
                    onClick = {
                        onActions(UnknownHostActions.Repeat)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.unknown_host_button).uppercase())
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            UnknownHostBody()
        }
    }
}
