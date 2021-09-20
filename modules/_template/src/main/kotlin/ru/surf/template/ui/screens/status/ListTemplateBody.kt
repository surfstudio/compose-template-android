package ru.surf.template.ui.screens.status

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.accompanist.SwipeRefreshList
import com.keygenqt.modifier.paddingLarge
import ru.surf.core.compose.Loader
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.ui.actions.ListTemplateActions

@Composable
// It screen base after init
// @todo {ScreenName}Body
fun ListTemplateBody(
    search: String?,
    items: LazyPagingItems<TemplateModel>,
    searchItems: LazyPagingItems<TemplateModel>,
    onActions: (ListTemplateActions) -> Unit = {},
) {
    MainScaffoldSearch(
        contentTitle = {
            TopBarContentTitle("Title")
        },
        searchListener = { value ->
            onActions(ListTemplateActions.Search(value))
            searchItems.refresh()
        }
    ) {

        val contentEmpty = @Composable {
            // empty content
        }

        val contentLoadState = @Composable { loadState: LoadState ->
            if (loadState is LoadState.Loading) {
                Loader(Modifier.paddingLarge())
            }
        }

        search?.let {
            SwipeRefreshList(
                modifier = Modifier,
                items = searchItems,
                state = rememberSwipeRefreshState(searchItems.loadState.refresh is LoadState.Loading),
                contentEmpty = contentEmpty,
                contentLoadState = contentLoadState
            ) { _, model ->
                ListTemplateItem(model = model)
            }
        } ?: run {
            SwipeRefreshList(
                modifier = Modifier,
                items = items,
                state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
                contentEmpty = contentEmpty,
                contentLoadState = contentLoadState
            ) { _, model ->
                ListTemplateItem(model = model)
            }
        }
    }
}
