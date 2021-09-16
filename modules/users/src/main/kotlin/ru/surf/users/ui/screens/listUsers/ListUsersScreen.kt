package ru.surf.users.ui.screens.listUsers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.UsersActions
import ru.surf.users.ui.viewModels.UsersViewModel

@Composable
fun ListUsersScreen(
    viewModel: UsersViewModel,
    onEvent: (UsersActions) -> Unit = {},
) {
    val search: String? by viewModel.search.collectAsState()
    val items: LazyPagingItems<UserModel> = viewModel.listUsers.collectAsLazyPagingItems()
    val searchItems: LazyPagingItems<UserModel> = viewModel.searchListUsers.collectAsLazyPagingItems()

    ListUsersBody(
        search = search,
        items = items,
        searchItems = searchItems,
        onEvent = onEvent,
    )
}
