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
package ru.surf.settings.navigation.graph.impl

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import ru.surf.settings.navigation.actions.SettingsNavActions
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.settings.ui.actions.SettingsActions
import ru.surf.settings.ui.screens.settings.SettingsScreen
import ru.surf.settings.ui.viewModels.SettingsViewModel

/**
 * NavGraph for [SettingsScreen]
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.settingsScreenGraph(
    scaffoldState: ScaffoldState,
    navActions: SettingsNavActions,
) {
    composable(SettingsNav.MainNav.SettingsNavScreen.route) {
        val coroutineScope = rememberCoroutineScope()
        val viewModel: SettingsViewModel = hiltViewModel()
        SettingsScreen(viewModel = viewModel) { event ->
            when (event) {
                is SettingsActions.UpdateSettings -> viewModel.updateSettings()
                is SettingsActions.OpenMenu -> coroutineScope.launch { scaffoldState.drawerState.open() }
            }
        }
    }
}
