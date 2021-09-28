/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import ru.surf.core.R

/**
 * Box with animated loader
 *
 * @param modifier Modifier to be applied to the layout
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun Loader(
    modifier: Modifier = Modifier
) {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading_animation),
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        LottieAnimation(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.Center),
            composition = composition,
            progress = progress,
        )
    }
}
