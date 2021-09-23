package ru.surf.users.navigation.graph.impl

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import kotlinx.coroutines.launch
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.users.ui.actions.ListUsersActions
import ru.surf.users.ui.actions.ViewUserActions
import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.screens.viewUser.ViewUserScreen
import ru.surf.users.ui.viewModels.UsersViewModel

fun NavGraphBuilder.usersScreenGraph(
    scaffoldState: ScaffoldState,
    navActions: UsersNavActions,
) {
    composable(UsersNav.MainNav.ListUsersScreen.route) {
        val coroutineScope = rememberCoroutineScope()
        val viewModel: UsersViewModel = hiltViewModel()
        ListUsersScreen(viewModel = viewModel) { event ->
            when (event) {
                is ListUsersActions.OpenMenu -> coroutineScope.launch { scaffoldState.drawerState.open() }
                is ListUsersActions.Search -> viewModel.search(event.text)
                is ListUsersActions.ToViewUser -> navActions.toUser(event.userId)
            }
        }
    }
    composable(
        route = UsersNav.MainNav.ViewUserScreen.routeWithArgument,
        arguments = listOf(navArgument(UsersNav.MainNav.ViewUserScreen.argument0) {
            type = NavType.StringType
        })
    ) { backStackEntry ->
        backStackEntry.arguments?.let {
            val viewModel: UsersViewModel = hiltViewModel()
            val userId = it.getString(UsersNav.MainNav.ViewUserScreen.argument0)!!
            ViewUserScreen(
                userId = userId,
                viewModel = viewModel,
            ) { event ->
                when (event) {
                    is ViewUserActions.RefreshView -> viewModel.updateUser(event.userId)
                }
            }
        }
    }
}