package ru.surf.other.ui.screens.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.surf.other.ui.actions.WelcomeActions

@Composable
fun WelcomeBody(
    onActions: (WelcomeActions) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "Welcome"
        )
    }
}
