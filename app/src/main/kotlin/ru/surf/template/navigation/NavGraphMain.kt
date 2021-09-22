package ru.surf.template.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.surf.core.navigation.graph.mainNavGraph
import ru.surf.core.navigation.nav.CoreNav


@Composable
fun NavGraphMain(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
    ) {
        NavHost(navController = navController, startDestination = CoreNav.StatusNav.StatusScreen.route) {
            mainNavGraph(
                navActions = navActions,
            )
        }
    }
}


