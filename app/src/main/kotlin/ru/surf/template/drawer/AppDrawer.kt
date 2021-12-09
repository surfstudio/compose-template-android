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
package ru.surf.template.drawer

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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.core.extension.EmitByStatus
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.users.navigation.nav.UsersNav
import ru.surfstudio.compose.modifier.spaceBase
import ru.surf.core.R as RCore

/**
 * Application menu
 *
 * @param scaffoldState just [rememberScaffoldState]
 * @param currentRoute string route navigation
 * @param onActions callback with [AppDrawerActions]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun AppDrawer(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    currentRoute: String = UsersNav.MainNav.ListUsersNavScreen.route,
    onActions: (AppDrawerActions) -> Unit = {},
) {
    val scope = rememberCoroutineScope()

    SetBackDispatcherAppDrawer(scaffoldState)

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
        Spacer(modifier = Modifier.spaceBase())

        AppDrawerItem(
            isSelected = currentRoute == UsersNav.MainNav.ListUsersNavScreen.route,
            label = stringResource(id = RCore.string.menu_members),
            icon = Icons.Filled.People,
            onClick = onClick(AppDrawerActions.ToUsers)
        )

        AppDrawerItem(
            isSelected = currentRoute == SettingsNav.MainNav.SettingsNavScreen.route,
            label = stringResource(id = RCore.string.menu_settings),
            icon = Icons.Filled.Settings,
            onClick = onClick(AppDrawerActions.ToSettings)
        )
    }
}

/**
 * Init listen dispatcher
 *
 * @param scaffoldState just [rememberScaffoldState]
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SetBackDispatcherAppDrawer(
    scaffoldState: ScaffoldState
) {
    val scope: CoroutineScope = rememberCoroutineScope()
    val backDispatcher = LocalBackPressedDispatcher.current

    backDispatcher.EmitByStatus(scaffoldState.drawerState.isOpen) {
        scope.launch { scaffoldState.drawerState.close() }
    }
}
