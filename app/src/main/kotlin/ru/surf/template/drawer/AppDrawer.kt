/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.drawer

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.systemBarsPadding
import com.keygenqt.modifier.sizeMedium
import kotlinx.coroutines.launch
import ru.surf.core.extension.EmitByStatus
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.core.R as RCore

@Composable
fun AppDrawer(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    currentRoute: String = UsersNav.MainNav.ListUsersScreen.route,
    backDispatcher: OnBackPressedDispatcher? = null,
    onActions: (AppDrawerActions) -> Unit = {},
) {
    val scope = rememberCoroutineScope()

    backDispatcher?.EmitByStatus(scaffoldState.drawerState.isOpen) {
        scope.launch { scaffoldState.drawerState.close() }
    }

    val onClick: (AppDrawerActions) -> () -> Unit = { event ->
        {
            onActions(event)
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .systemBarsPadding()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.sizeMedium())

        AppDrawerItem(
            isSelected = currentRoute == UsersNav.MainNav.ListUsersScreen.route,
            label = stringResource(id = RCore.string.menu_members),
            icon = Icons.Filled.People,
            onClick = onClick(AppDrawerActions.ToUsers)
        )

        AppDrawerItem(
            isSelected = currentRoute == SettingsNav.MainNav.SettingsScreen.route,
            label = stringResource(id = RCore.string.menu_settings),
            icon = Icons.Filled.Settings,
            onClick = onClick(AppDrawerActions.ToSettings)
        )
    }
}
