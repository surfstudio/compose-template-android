/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.screens.signIn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.viewModels.OtherViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SignInScreen(
    viewModel: OtherViewModel,
    onActions: (SignInActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()
    val commonError: String? by viewModel.commonError.collectAsState(null)

    SignInBody(
        loading = loading,
        onActions = onActions,
        commonError = commonError,
        backDispatcher = LocalBackPressedDispatcher.current,
    )
}
