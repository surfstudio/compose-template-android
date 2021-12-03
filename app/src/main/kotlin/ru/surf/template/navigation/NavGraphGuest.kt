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
package ru.surf.template.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.surf.other.navigation.graph.otherNavGraph
import ru.surf.other.navigation.nav.OtherNav

/**
 * Navigation graph for guest
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun NavGraphGuest(navController: NavHostController) {

    val navActions = remember(navController) {
        NavActions(navController)
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
    ) {
        NavHost(navController = navController, startDestination = OtherNav.WelcomeNav.WelcomeNavScreen.route) {
            otherNavGraph(
                navActions = navActions,
            )
        }
    }
}
