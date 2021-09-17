package ru.surf.other.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.actions.WelcomeActions
import ru.surf.other.ui.screens.welcome.WelcomeScreen
import ru.surf.other.ui.viewModels.OtherViewModel

fun NavGraphBuilder.welcomeScreenGraph(
    navActions: OtherNavActions,
) {
    composable(OtherNav.WelcomeNav.WelcomeScreen.route) {
        val viewModel: OtherViewModel = hiltViewModel()
        WelcomeScreen(viewModel = viewModel) { event ->
            when (event) {
                is WelcomeActions.ToSignIn -> {

                }
                is WelcomeActions.ToSignUp -> {

                }
            }
        }
    }
}