package ru.surf.users.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.users.ui.screens.listUsers.ListUsersScreen

fun NavGraphBuilder.usersScreenGraph(
    navActions: UsersNavActions,
) {
    composable(UsersNav.MainNav.ListUsersScreen.route) {
        ListUsersScreen(viewModel = hiltViewModel()) { event ->

        }
    }
}