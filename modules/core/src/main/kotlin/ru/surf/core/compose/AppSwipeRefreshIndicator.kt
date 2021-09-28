/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.compose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import ru.surf.core.base.MaterialThemeCustom

/**
 * Indicator for [SwipeRefresh]
 *
 * @param state The [SwipeRefreshState] passed into the [SwipeRefresh] `indicator` block.
 * @param refreshTrigger the max y offset.
 *
 * @author Vitaliy Zarubin
 */
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
