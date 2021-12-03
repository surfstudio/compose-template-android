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
package ru.surf.users.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.screens.viewUser.ViewUserScreen

/**
 * Custom actions for [ListUsersScreen], [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
interface UsersScreenActions {

    val controller: NavHostController

    fun toUsers() {
        controller.navigate(UsersNav.MainNav.ListUsersNavScreen.route)
    }

    fun toUser(userId: String) {
        UsersNav.MainNav.ViewUserNavScreen.apply {
            controller.navigate(getRoute(userId))
        }
    }
}
