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
package ru.surf.core.navigation.graph.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.core.navigation.nav.CoreNav
import ru.surf.core.ui.actions.UnknownHostActions
import ru.surf.core.ui.screens.status.StatusScreen

/**
 * NavGraph for [StatusScreen]
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.statusScreenGraph(
    navActions: CoreNavActions,
) {
    composable(CoreNav.StatusNav.StatusNavScreen.route) {
        val viewModel = LocalMainViewModel.current
        StatusScreen(viewModel = viewModel) { event ->
            when (event) {
                is UnknownHostActions.Repeat -> viewModel.updateSettings()
            }
        }
    }
}
