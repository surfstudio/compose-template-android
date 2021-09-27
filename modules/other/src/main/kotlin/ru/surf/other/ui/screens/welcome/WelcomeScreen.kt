/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.screens.welcome

import androidx.compose.runtime.Composable
import ru.surf.other.ui.actions.WelcomeActions
import ru.surf.other.ui.viewModels.OtherViewModel

@Composable
fun WelcomeScreen(
    viewModel: OtherViewModel,
    onActions: (WelcomeActions) -> Unit = {},
) {
    WelcomeBody(
        onActions = onActions,
    )
}
