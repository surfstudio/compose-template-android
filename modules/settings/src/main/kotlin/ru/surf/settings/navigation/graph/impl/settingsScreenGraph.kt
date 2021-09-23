package ru.surf.settings.navigation.graph.impl

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import ru.surf.settings.navigation.actions.SettingsNavActions
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.settings.ui.actions.SettingsActions
import ru.surf.settings.ui.screens.settings.SettingsScreen
import ru.surf.settings.ui.viewModels.SettingsViewModel

fun NavGraphBuilder.settingsScreenGraph(
    scaffoldState: ScaffoldState,
    navActions: SettingsNavActions,
) {
    composable(SettingsNav.MainNav.SettingsScreen.route) {
        val coroutineScope = rememberCoroutineScope()
        val viewModel: SettingsViewModel = hiltViewModel()
        SettingsScreen(viewModel = viewModel) { event ->
            when (event) {
                is SettingsActions.OpenMenu -> coroutineScope.launch { scaffoldState.drawerState.open() }
            }
        }
    }
}