/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.ui.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.settings.ui.actions.SettingsActions
import ru.surf.settings.ui.viewModels.SettingsViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onActions: (SettingsActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()

    SettingsBody(
        loading = loading,
        onActions = onActions,
    )
}
