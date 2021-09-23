package ru.surf.users.ui.screens.listUsers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.insets.navigationBarsWithImePadding
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.R as CoreR
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ListUsersActions
import ru.surf.users.ui.viewModels.UsersViewModel

@Composable
fun ListUsersScreen(
    viewModel: UsersViewModel,
    onActions: (ListUsersActions) -> Unit = {},
) {
    val search: String? by viewModel.search.collectAsState()
    val items: LazyPagingItems<UserModel> = viewModel.listUsers.collectAsLazyPagingItems()
    val searchItems: LazyPagingItems<UserModel> = viewModel.searchListUsers.collectAsLazyPagingItems()
    val showSnackBar: Boolean by LocalMainViewModel.current.showSnackBar.collectAsState()

    Box(Modifier.defaultMinSize()) {
        ListUsersBody(
            search = search,
            items = items,
            searchItems = searchItems,
            onActions = onActions,
        )

        if (showSnackBar) {
            Snackbar(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomStart)
                    .navigationBarsWithImePadding()
            ) { Text(text = stringResource(id = CoreR.string.common_exit_info)) }
        }
    }
}
