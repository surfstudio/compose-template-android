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
import ru.surf.other.navigation.graph.otherNavGraph
import ru.surf.other.navigation.nav.OtherNav


@Composable
fun NavGraphGuest(navController: NavHostController) {

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
                NavHost(navController = navController, startDestination = OtherNav.WelcomeNav.WelcomeScreen.route) {
                    otherNavGraph(
                        navActions = navActions,
                    )
                }
            }
        }
    }
}


