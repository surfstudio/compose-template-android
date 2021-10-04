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

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.accompanist.SwipeRefreshList
import com.keygenqt.modifier.paddingSmall
import kotlinx.coroutines.flow.flow
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.base.MainViewModel
import ru.surf.core.compose.*
import ru.surf.core.utils.HelperApp
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ListUsersActions
import ru.surf.core.R as RCore

/**
 * Body page [ListUsersScreen]
 *
 * @param search state call query to api
 * @param items list paging list [LazyPagingItems]
 * @param searchItems searching list paging list [LazyPagingItems]
 * @param onActions actions page
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun ListUsersBody(
    search: String?,
    items: LazyPagingItems<UserModel>,
    searchItems: LazyPagingItems<UserModel>,
    onActions: (ListUsersActions) -> Unit = {},
    localMainViewModel: MainViewModel? = LocalMainViewModel.current
) {
    var expanded by remember { mutableStateOf(false) }
    val contentLoading = @Composable { LoaderPage() }
    val contentEmpty = @Composable {
        EmptyPage()
    }
    val contentLoadState = @Composable { loadState: LoadState ->
        if (loadState is LoadState.Loading) {
            Loader(Modifier.paddingSmall())
            Spacer(modifier = Modifier.paddingSmall())
        }
    }

    MainScaffoldSearch(
        modifier = Modifier.systemBarsPadding(),
        navigationIcon = Icons.Default.Menu,
        navigationIconOnClick = { onActions(ListUsersActions.OpenMenu) },
        contentTitle = {
            TopBarContentTitle(stringResource(id = RCore.string.menu_members))
        },
        searchListener = { value ->
            onActions(ListUsersActions.Search(value))
            searchItems.refresh()
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Options menu"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    localMainViewModel?.logout()
                }) {
                    Text("Logout")
                }
            }
        }
    ) {
        search?.let {
            SwipeRefreshList(
                modifier = Modifier,
                items = searchItems,
                state = rememberSwipeRefreshState(searchItems.loadState.refresh is LoadState.Loading),
                indicator = { st, tr ->
                    AppSwipeRefreshIndicator(st, tr)
                },
                contentEmpty = contentEmpty,
                contentLoadState = contentLoadState,
                contentLoading = contentLoading,
            ) { _, model ->
                ListUserItem(model = model, onActions = onActions)
            }
        } ?: run {
            SwipeRefreshList(
                modifier = Modifier,
                items = items,
                state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
                indicator = { st, tr ->
                    AppSwipeRefreshIndicator(st, tr)
                },
                contentEmpty = contentEmpty,
                contentLoadState = contentLoadState,
                contentLoading = contentLoading,
            ) { _, model ->
                ListUserItem(model = model, onActions = onActions)
            }
        }
    }
}
