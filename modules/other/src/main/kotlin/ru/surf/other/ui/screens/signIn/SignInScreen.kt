package ru.surf.other.ui.screens.signIn

import androidx.compose.runtime.Composable
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.viewModels.OtherViewModel

@Composable
fun SignInScreen(
    viewModel: OtherViewModel,
    onActions: (SignInActions) -> Unit = {},
) {
    SignInBody(
        onActions = onActions,
    )
}
