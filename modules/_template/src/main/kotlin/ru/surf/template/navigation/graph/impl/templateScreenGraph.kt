/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.template.navigation.actions.TemplateNavActions
import ru.surf.template.navigation.nav.TemplateNav
import ru.surf.template.ui.actions.ListTemplateActions
import ru.surf.template.ui.screens.status.ListTemplateScreen
import ru.surf.template.ui.viewModels.TemplateViewModel

// @todo {ScreenName}ScreenGraph
// @todo {ScreenName}NavActions
fun NavGraphBuilder.templateScreenGraph(
    navActions: TemplateNavActions,
) {
    composable(TemplateNav.MainNav.ListTemplateScreen.route) {
        val viewModel: TemplateViewModel = hiltViewModel()
        ListTemplateScreen(viewModel = viewModel) { event ->
            when (event) {
                is ListTemplateActions.Search -> viewModel.search(event.text)
            }
        }
    }
}
