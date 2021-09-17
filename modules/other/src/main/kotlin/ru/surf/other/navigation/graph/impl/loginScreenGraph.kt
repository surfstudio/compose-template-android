package ru.surf.other.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.actions.LoginActions
import ru.surf.other.ui.screens.login.LoginScreen
import ru.surf.other.ui.viewModels.OtherViewModel

fun NavGraphBuilder.loginScreenGraph(
    navActions: OtherNavActions,
) {
    composable(OtherNav.LoginNav.LoginScreen.route) {
        val viewModel: OtherViewModel = hiltViewModel()
        LoginScreen(viewModel = viewModel) { event ->
            when (event) {
                is LoginActions.Search -> {

                }
            }
        }
    }
}