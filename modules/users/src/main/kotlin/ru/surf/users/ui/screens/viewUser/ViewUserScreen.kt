package ru.surf.users.ui.screens.viewUser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.users.ui.actions.ViewUserActions
import ru.surf.users.ui.viewModels.UsersViewModel

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
