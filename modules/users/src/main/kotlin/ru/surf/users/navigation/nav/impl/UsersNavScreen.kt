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
package ru.surf.users.navigation.nav.impl

import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.screens.viewUser.ViewUserScreen
import ru.surfstudio.compose.routing.NavScreen
import ru.surfstudio.compose.routing.NavScreenWithArgument

/**
 * Routing for [ListUsersScreen], [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
object UsersNavScreen {
    val ListUsersNavScreen = object : NavScreen {
        override val route: String = "ListUsersScreen"
    }
    val ViewUserNavScreen = object : NavScreenWithArgument {
        override val argument0: String = "userId"
        override val routeWithArgument: String = "ViewUserScreen/{$argument0}"
    }
}
