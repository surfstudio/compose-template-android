/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
