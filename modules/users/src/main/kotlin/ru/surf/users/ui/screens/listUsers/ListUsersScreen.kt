/**
 * Copyright 2021 Surf
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
package ru.surf.users.ui.screens.listUsers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.flow.flow
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ListUsersActions
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
fun ListUsersScreen(
    viewModel: UsersViewModel,
    onActions: (ListUsersActions) -> Unit = {},
) {
    val search: String? by viewModel.search.collectAsState()
    val items: LazyPagingItems<UserModel> = viewModel.listUsers.collectAsLazyPagingItems()
    val searchItems: LazyPagingItems<UserModel> = viewModel.searchListUsers.collectAsLazyPagingItems()

    ListUsersBody(
        search = search,
        items = flow {
            emit(PagingData.empty<UserModel>())
        }.collectAsLazyPagingItems(),
        searchItems = flow {
            emit(PagingData.empty<UserModel>())
        }.collectAsLazyPagingItems(),
        onActions = onActions,
    )
}
