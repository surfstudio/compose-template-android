/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsWithImePadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.R
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.core.extension.EmitByStatus
import ru.surf.settings.navigation.graph.impl.settingsScreenGraph
import ru.surf.template.drawer.AppDrawer
import ru.surf.template.drawer.AppDrawerActions
import ru.surf.users.navigation.graph.usersNavGraph
import ru.surf.users.navigation.nav.UsersNav

/**
 * Navigation graph for member
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun NavGraph(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val backDispatcher = LocalBackPressedDispatcher.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: UsersNav.MainNav.ListUsersScreen.route

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                backDispatcher = backDispatcher,
                scaffoldState = scaffoldState,
                currentRoute = currentRoute,
            ) { event ->
                when (event) {
                    is AppDrawerActions.ToUsers -> navActions.toUsers()
                    is AppDrawerActions.ToSettings -> navActions.toSettings()
                }
            }
        }
    ) {
        Box(Modifier.defaultMinSize()) {

            NavHost(navController = navController, startDestination = UsersNav.MainNav.ListUsersScreen.route) {
                usersNavGraph(
                    scaffoldState = scaffoldState,
                    navActions = navActions,
                )
                settingsScreenGraph(
                    scaffoldState = scaffoldState,
                    navActions = navActions,
                )
            }

            // show snackBar before exit
            var showSnackbar by remember { mutableStateOf(false) }

            backDispatcher.EmitByStatus(
                !showSnackbar &&
                    listOf(
                        UsersNav.MainNav.ListUsersScreen.route
                    ).contains(currentRoute)
            ) {
                showSnackbar = true
                scope.launch {
                    delay(1000)
                    showSnackbar = false
                }
            }
            if (showSnackbar) {
                Snackbar(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.BottomStart)
                        .navigationBarsWithImePadding()
                ) {
                    Text(text = stringResource(id = R.string.common_exit_info))
                }
            }
        }
    }
}
