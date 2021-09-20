package ru.surf.other.ui.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.airbnb.lottie.compose.*
import com.keygenqt.accompanist.ClickableTextColorAnimation
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingXLarge
import com.keygenqt.modifier.sizeXLarge
import ru.surf.core.base.MaterialThemeCustom
import ru.surf.other.R
import ru.surf.other.ui.actions.WelcomeActions

@Composable
fun WelcomeBody(
    onActions: (WelcomeActions) -> Unit = {},
) {

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
            Logo(
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

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.welcome_btn_sign_in).uppercase())
            }

            Spacer(modifier = Modifier.sizeXLarge())

            ClickableTextColorAnimation(
                onClick = {

                },
                text = stringResource(id = R.string.welcome_btn_sign_up),
                colorDefault = MaterialThemeCustom.colors.link,
                colorAction = MaterialThemeCustom.colors.linkAction,
            )

            Spacer(modifier = Modifier.sizeXLarge())
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


    }
}

@Composable
fun Logo(
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

