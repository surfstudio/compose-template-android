/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

/**
 * NavGraph for [ListUsersScreen], [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.usersScreenGraph(
    scaffoldState: ScaffoldState,
    navActions: UsersNavActions,
) {
    composable(UsersNav.MainNav.ListUsersNavScreen.route) {
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
        route = UsersNav.MainNav.ViewUserNavScreen.routeWithArgument,
        arguments = listOf(
            navArgument(UsersNav.MainNav.ViewUserNavScreen.argument0) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        backStackEntry.arguments?.let {
            val viewModel: UsersViewModel = hiltViewModel()
            val userId = it.getString(UsersNav.MainNav.ViewUserNavScreen.argument0)!!
            ViewUserScreen(
                userId = userId,
                viewModel = viewModel,
            ) { event ->
                when (event) {
                    is ViewUserActions.RefreshView -> viewModel.getViewUser(event.userId)
                }
            }
        }
    }
}
