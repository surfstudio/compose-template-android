package ru.surf.core.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun AppSwipeRefreshIndicator(
    state: SwipeRefreshState,
    refreshTrigger: Dp
) {
    SwipeRefreshIndicator(
        state = state,
        refreshTriggerDistance = refreshTrigger,
        contentColor = MaterialTheme.colors.primary,
    )
}