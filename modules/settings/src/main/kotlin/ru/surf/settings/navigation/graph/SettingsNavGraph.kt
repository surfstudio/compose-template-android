package ru.surf.settings.navigation.graph

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavGraphBuilder
import ru.surf.settings.navigation.actions.SettingsNavActions
import ru.surf.settings.navigation.graph.impl.settingsScreenGraph

fun NavGraphBuilder.settingsNavGraph(
    scaffoldState: ScaffoldState,
    navActions: SettingsNavActions,
) {
    settingsScreenGraph(scaffoldState, navActions)
}