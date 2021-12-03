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
package ru.surf.other.navigation.graph.impl

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.actions.WelcomeActions
import ru.surf.other.ui.screens.welcome.WelcomeScreen
import ru.surf.other.ui.viewModels.OtherViewModel

/**
 * NavGraph for [WelcomeScreen]
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.welcomeScreenGraph(
    navActions: OtherNavActions,
) {
    composable(OtherNav.WelcomeNav.WelcomeNavScreen.route) {
        val viewModel: OtherViewModel = hiltViewModel()
        WelcomeScreen(viewModel = viewModel) { event ->
            when (event) {
                is WelcomeActions.ToSignIn -> navActions.toSignIn()
                is WelcomeActions.ToSignUp -> navActions.toSignUp()
            }
        }
    }
}
