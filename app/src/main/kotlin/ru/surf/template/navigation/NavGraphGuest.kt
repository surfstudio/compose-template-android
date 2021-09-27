/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.surf.other.navigation.graph.otherNavGraph
import ru.surf.other.navigation.nav.OtherNav

@Composable
fun NavGraphGuest(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
    ) {
        NavHost(navController = navController, startDestination = OtherNav.WelcomeNav.WelcomeScreen.route) {
            otherNavGraph(
                navActions = navActions,
            )
        }
    }
}
