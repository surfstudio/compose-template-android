/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.accompanist.SwipeRefreshList
import com.keygenqt.modifier.paddingSmall
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.compose.*
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ListUsersActions
import ru.surf.core.R as RCore

@Composable
fun ListUsersBody(
    search: String?,
    items: LazyPagingItems<UserModel>,
    searchItems: LazyPagingItems<UserModel>,
    onActions: (ListUsersActions) -> Unit = {},
) {
    val localMainViewModel = LocalMainViewModel.current
    var expanded by remember { mutableStateOf(false) }
    val contentLoading = @Composable { LoaderPage() }
    val contentEmpty = @Composable { EmptyPage() }
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
                    localMainViewModel.logout()
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
