package ru.surf.other.ui.screens.login

import androidx.compose.runtime.Composable
import ru.surf.other.ui.actions.LoginActions
import ru.surf.other.ui.viewModels.OtherViewModel

@Composable
fun LoginScreen(
    viewModel: OtherViewModel,
    onActions: (LoginActions) -> Unit = {},
) {
    LoginBody(
        onActions = onActions,
    )
}
