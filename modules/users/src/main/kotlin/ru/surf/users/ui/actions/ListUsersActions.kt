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
package ru.surf.users.ui.actions

import ru.surf.users.ui.screens.listUsers.ListUsersScreen

/**
 * Actions sealed class for screen [ListUsersScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class ListUsersActions {

    /**
     * Open main menu
     */
    object OpenMenu : ListUsersActions()

    /**
     * Find models by name
     *
     * @param text search text for query
     */
    class Search(val text: String?) : ListUsersActions()

    /**
     * Open page view user
     *
     * @param userId user identifier
     */
    class ToViewUser(val userId: String) : ListUsersActions()
}
