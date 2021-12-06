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

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import ru.surf.core.R
import ru.surf.core.theme.MainAppTheme
import ru.surfstudio.compose.modifier.spacePage

/**
 * Animation for page
 *
 * @param modifier Modifier to be applied to the layout
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun EmptyPageAnimation(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.empty_page))
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

/**
 * Block for show info about page is empty
 *
 * @param modifier Modifier to be applied to the layout
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun EmptyPage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .testTag("Animation not found")
            .fillMaxSize()
            .spacePage()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            EmptyPageAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            EmptyPage()
        }
    }
}
