package ru.surf.other.ui.screens.signUp

import androidx.compose.runtime.Composable
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.viewModels.OtherViewModel

@Composable
fun SignUpScreen(
    viewModel: OtherViewModel,
    onActions: (SignUpActions) -> Unit = {},
) {
    SignUpBody(
        onActions = onActions,
    )
}
