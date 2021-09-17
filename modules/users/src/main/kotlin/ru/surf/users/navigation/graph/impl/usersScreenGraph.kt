package ru.surf.users.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.users.ui.actions.ListUsersActions
import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.viewModels.UsersViewModel

fun NavGraphBuilder.usersScreenGraph(
    navActions: UsersNavActions,
) {
    composable(UsersNav.MainNav.ListUsersScreen.route) {
        val viewModel: UsersViewModel = hiltViewModel()
        ListUsersScreen(viewModel = viewModel) { event ->
            when (event) {
                is ListUsersActions.Search -> viewModel.search(event.text)
            }
        }
    }
}