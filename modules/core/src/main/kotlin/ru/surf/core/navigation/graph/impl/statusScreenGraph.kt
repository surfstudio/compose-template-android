/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.navigation.graph.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.core.navigation.nav.CoreNav
import ru.surf.core.ui.actions.UnknownHostActions
import ru.surf.core.ui.screens.status.StatusScreen

/**
 * NavGraph for [StatusScreen]
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.statusScreenGraph(
    navActions: CoreNavActions,
) {
    composable(CoreNav.StatusNav.StatusScreen.route) {
        val viewModel = LocalMainViewModel.current
        StatusScreen(viewModel = viewModel) { event ->
            when (event) {
                is UnknownHostActions.Repeat -> viewModel.updateSettings()
            }
        }
    }
}
