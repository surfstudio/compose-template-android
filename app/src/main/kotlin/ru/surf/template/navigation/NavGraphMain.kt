package ru.surf.template.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.insets.ProvideWindowInsets
import ru.surf.template.navigation.graph.mainNavGraph
import ru.surf.template.navigation.nav.AppNav


@Composable
fun NavGraphMain(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    ProvideWindowInsets {
        Scaffold(
            scaffoldState = rememberScaffoldState(),
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                NavHost(navController = navController, startDestination = AppNav.StatusNav.StatusScreen.route) {
                    mainNavGraph(
                        navActions = navActions,
                    )
                }
            }
        }
    }
}


