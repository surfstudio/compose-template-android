package ru.surf.settings.ui.screens.settings

import androidx.compose.runtime.Composable
import ru.surf.settings.ui.actions.SettingsActions
import ru.surf.settings.ui.viewModels.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onActions: (SettingsActions) -> Unit = {},
) {
    ListSettingsBody(
        onActions = onActions,
    )
}
