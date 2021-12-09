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
package ru.surf.other.ui.screens.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.google.accompanist.insets.systemBarsPadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.base.MaterialThemeCustom
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.WelcomeActions
import ru.surfstudio.compose.accompanist.ClickableTextColorAnimation
import ru.surfstudio.compose.modifier.*

/**
 * Page animation
 */
@Composable
fun WelcomeAnimation(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.team))
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
 * Body page [WelcomeScreen]
 *
 * @param onActions actions page
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun WelcomeBody(
    onActions: (WelcomeActions) -> Unit = {},
) {
    val delayClick = 150L
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .systemBarsPadding()
            .spacePage()
    ) {
        Box(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                style = MaterialThemeCustom.typography.title,
                text = stringResource(id = R.string.welcome_title)
            )
        }
        Box(
            modifier = Modifier
                .weight(0.4f)
                .spacePage()
                .fillMaxSize()
        ) {
            WelcomeAnimation(
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
            Button(
                onClick = {
                    scope.launch {
                        delay(delayClick)
                        onActions(WelcomeActions.ToSignIn)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.welcome_btn_sign_in).uppercase())
            }

            Spacer(modifier = Modifier.spaceForm())

            ClickableTextColorAnimation(
                delay = delayClick,
                enabled = true,
                colorDisable = MaterialThemeCustom.colors.link,
                colorDefault = MaterialThemeCustom.colors.link,
                colorAction = MaterialThemeCustom.colors.linkAction,
                text = stringResource(id = R.string.welcome_btn_sign_up),
                onClick = {
                    onActions(WelcomeActions.ToSignUp)
                }
            )

            Spacer(modifier = Modifier.spaceSmall())
            Spacer(modifier = Modifier.spaceBase())
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            WelcomeBody()
        }
    }
}
