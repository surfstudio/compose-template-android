package ru.surf.template.navigation.graph.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.core.base.LocalMainViewModel
import ru.surf.template.navigation.actions.AppNavActions
import ru.surf.template.navigation.nav.AppNav
import ru.surf.template.ui.actions.UnknownHostActions
import ru.surf.template.ui.screens.status.StatusScreen

fun NavGraphBuilder.statusScreenGraph(
    navActions: AppNavActions,
) {
    composable(AppNav.StatusNav.StatusScreen.route) {
        val viewModel = LocalMainViewModel.current
        StatusScreen(viewModel = viewModel) { event ->
            when (event) {
                is UnknownHostActions.Repeat -> viewModel.updateSettings()
            }
        }
    }
}