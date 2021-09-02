package ru.surf.users.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import ru.surf.users.extensions.visible
import timber.log.Timber

@Composable
fun <T : Any> CommonList(
    modifier: Modifier = Modifier,
    padding: Dp = 16.dp,
    paddingBottom: Dp = 0.dp,
    items: LazyPagingItems<T>,
    state: SwipeRefreshState,
    contentEmpty: @Composable () -> Unit = {},
    content: @Composable (Int, T) -> Unit,
) {
    SwipeRefresh(
        state = state,
        onRefresh = {
            items.refresh()
        },
        indicator = { st, tr ->
            SwipeRefreshIndicator(
                state = st,
                refreshTriggerDistance = tr,
                contentColor = MaterialTheme.colors.onPrimary,
            )
        },
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        if (items.itemCount != 0) {
            LazyColumn(
                contentPadding = PaddingValues(start = padding, top = padding, end = padding, bottom = paddingBottom),
                modifier = Modifier
                    .fillMaxSize()
                    .visible(items.loadState.refresh !is LoadState.Loading)
            ) {
                itemsIndexed(items) { index, item ->
                    item?.let {
                        content.invoke(index, item)
                    }
                }
                items.apply {
                    when {
                        loadState.append is LoadState.Loading -> {
                            item {
                                Loader(
                                    modifier = Modifier
                                        .padding(bottom = 16.dp)
                                )
                            }
                        }
                        loadState.refresh is LoadState.Error -> {
                            val error = items.loadState.refresh as? LoadState.Error
                            error?.let {
                                item {
                                    Timber.e("Refresh error: $error.error.localizedMessage")
                                }
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            val error = items.loadState.refresh as? LoadState.Error
                            error?.let {
                                item {
                                    Timber.e("Append error: $error.error.localizedMessage")
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) { }
        }
    }

    if (items.loadState.mediator != null) {
        if (items.itemCount == 0
            && items.loadState.refresh !is LoadState.Loading
            && items.loadState.prepend !is LoadState.Loading
        ) {
            contentEmpty.invoke()
        }
        LoadingScreen(items.loadState.refresh is LoadState.Loading)
    }
}