package ru.surf.template.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.surf.users.navigation.graph.usersNavGraph
import ru.surf.users.navigation.nav.UsersNav


@Composable
fun NavGraph(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
    ) {
        NavHost(navController = navController, startDestination = UsersNav.MainNav.ListUsersScreen.route) {
            usersNavGraph(
                navActions = navActions,
            )
        }
    }
}


