/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.screens.signUp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.viewModels.OtherViewModel

@Composable
fun SignUpScreen(
    viewModel: OtherViewModel,
    onActions: (SignUpActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()
    val commonError: String? by viewModel.commonError.collectAsState(null)
    val commonSuccess: Boolean? by viewModel.commonSuccess.collectAsState(null)

    SignUpBody(
        loading = loading,
        onActions = onActions,
        commonError = commonError,
        commonSuccess = commonSuccess,
        backDispatcher = LocalBackPressedDispatcher.current,
    )
}
