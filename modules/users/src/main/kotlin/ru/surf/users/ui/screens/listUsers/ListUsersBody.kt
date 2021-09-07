package ru.surf.users.ui.screens.listUsers

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.SwipeRefreshList
import ru.surf.users.R
import ru.surf.users.compose.MainScaffold
import ru.surf.users.compose.PlugBlock
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.events.UsersEvents

@Composable
fun ListUsersBody(
    search: String?,
    items: LazyPagingItems<UserModel>,
    searchItems: LazyPagingItems<UserModel>,
    onEvent: (UsersEvents) -> Unit = {},
) {
    MainScaffold(
        elevation = 0.dp,
        title = stringResource(id = R.string.list_users_title),
        searchListener = { value ->
            onEvent(UsersEvents.Search(value))
            searchItems.refresh()
        }
    ) {
        val contentEmpty = @Composable {
            PlugBlock(
                title = stringResource(id = R.string.common_state_empty_title),
                text = stringResource(id = R.string.common_state_empty_text),
            )
        }
        search?.let {
            SwipeRefreshList(
                modifier = Modifier,
                items = searchItems,
                state = rememberSwipeRefreshState(searchItems.loadState.refresh is LoadState.Loading),
                contentEmpty = contentEmpty
            ) { _, model ->
                ListUserItem(model = model)
            }
        } ?: run {
            SwipeRefreshList(
                modifier = Modifier,
                items = items,
                state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
                contentEmpty = contentEmpty
            ) { _, model ->
                ListUserItem(model = model)
            }
        }

    }
}
