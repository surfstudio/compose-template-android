/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.core.base.LocalMainViewModel
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.screens.signIn.SignInScreen
import ru.surf.other.ui.viewModels.OtherViewModel

fun NavGraphBuilder.signInScreenGraph(
    navActions: OtherNavActions,
) {
    composable(OtherNav.SignInNav.SignInNavScreen.route) {
        val localMainViewModel = LocalMainViewModel.current
        val viewModel: OtherViewModel = hiltViewModel()
        SignInScreen(viewModel = viewModel) { event ->
            when (event) {
                is SignInActions.SignIn -> viewModel.signIn(event.email, event.pass) { userId, token ->
                    localMainViewModel.login(userId, token)
                }
            }
        }
    }
}
