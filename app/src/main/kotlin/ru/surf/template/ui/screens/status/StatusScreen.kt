package ru.surf.template.ui.screens.status

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.MainViewModel
import ru.surf.template.ui.actions.UnknownHostActions

@Composable
fun StatusScreen(
    viewModel: MainViewModel,
    onActions: (UnknownHostActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()
    val hasNetwork: Boolean by viewModel.hasNetwork.collectAsState()

    if (!hasNetwork) {
        UnknownHostBody(
            loading = loading,
            onActions = onActions,
        )
    }
}
