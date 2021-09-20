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
import com.keygenqt.accompanist.ClickableTextColorAnimation
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingXLarge
import com.keygenqt.modifier.sizeXLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.base.MaterialThemeCustom
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.WelcomeActions

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

@Composable
fun WelcomeBody(
    onActions: (WelcomeActions) -> Unit = {},
) {
    val delayClick = 150L
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .paddingLarge()
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
                .paddingXLarge()
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

            Spacer(modifier = Modifier.sizeXLarge())

            ClickableTextColorAnimation(
                delay = delayClick,
                colorDefault = MaterialThemeCustom.colors.link,
                colorAction = MaterialThemeCustom.colors.linkAction,
                text = stringResource(id = R.string.welcome_btn_sign_up),
                onClick = {
                    onActions(WelcomeActions.ToSignUp)
                }
            )

            Spacer(modifier = Modifier.sizeXLarge())
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