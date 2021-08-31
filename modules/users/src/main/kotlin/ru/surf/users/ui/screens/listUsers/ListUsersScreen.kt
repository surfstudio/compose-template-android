package ru.surf.users.ui.screens.listUsers

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.surf.users.ui.events.UsersEvents
import ru.surf.users.ui.viewModels.UsersViewModel

@Composable
fun ListUsersScreen(
    viewModel: UsersViewModel,
    onEvent: (UsersEvents) -> Unit = {},
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = "Hello!")
    }
}
