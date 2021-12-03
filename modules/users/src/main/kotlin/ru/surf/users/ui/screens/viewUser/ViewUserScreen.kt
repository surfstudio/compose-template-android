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
package ru.surf.users.ui.screens.viewUser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.users.ui.actions.ViewUserActions
import ru.surf.users.ui.viewModels.UsersViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun ViewUserScreen(
    userId: String,
    viewModel: UsersViewModel,
    onActions: (ViewUserActions) -> Unit = {},
) {

    val user by viewModel.getUser(userId).collectAsState(null)
    val loading: Boolean by viewModel.loading.collectAsState()
    val error404: Boolean by viewModel.error404.collectAsState()

    ViewUserBody(
        id = userId,
        model = user,
        loading = loading,
        error404 = error404,
        onActions = onActions,
        backDispatcher = LocalBackPressedDispatcher.current,
    )
}
