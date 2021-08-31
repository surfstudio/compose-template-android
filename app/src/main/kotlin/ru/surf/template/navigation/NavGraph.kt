package ru.surf.template.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.insets.ProvideWindowInsets
import ru.surf.users.navigation.graph.impl.usersScreenGraph
import ru.surf.users.navigation.nav.UsersNav


@Composable
fun NavGraph(navController: NavHostController) {

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
                NavHost(navController = navController, startDestination = UsersNav.MainNav.ListUsersScreen.route) {
                    usersScreenGraph(
                        navActions = navActions,
                    )
                }
            }
        }
    }
}


