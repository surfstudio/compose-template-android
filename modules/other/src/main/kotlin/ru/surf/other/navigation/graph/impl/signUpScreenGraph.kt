package ru.surf.other.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.screens.signUp.SignUpScreen
import ru.surf.other.ui.viewModels.OtherViewModel

fun NavGraphBuilder.signUpScreenGraph(
    navActions: OtherNavActions,
) {
    composable(OtherNav.SignUpNav.SignUpNavScreen.route) {
        val viewModel: OtherViewModel = hiltViewModel()
        SignUpScreen(viewModel = viewModel) { event ->
            when (event) {
                is SignUpActions.SignUp -> {

                }
            }
        }
    }
}