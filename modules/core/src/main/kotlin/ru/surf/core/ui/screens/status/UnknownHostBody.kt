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
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingXLarge
import com.keygenqt.modifier.sizeXLarge
import ru.surf.core.theme.MainAppTheme
import ru.surf.core.R
import ru.surf.core.ui.actions.UnknownHostActions

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
                style = MaterialTheme.typography.h6,
                text = stringResource(id = R.string.unknown_host_text)
            )
        }
        Box(
            modifier = Modifier
                .weight(0.4f)
                .paddingXLarge()
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
            UnknownHostBody()
        }
    }
}
