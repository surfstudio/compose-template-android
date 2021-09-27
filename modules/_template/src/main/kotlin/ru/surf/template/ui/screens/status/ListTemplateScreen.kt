/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.ui.screens.status

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.ui.actions.ListTemplateActions
import ru.surf.template.ui.viewModels.TemplateViewModel

@Composable
// It screen for init viewModel
// @todo {ScreenName}Screen
// @todo {ModuleName|ScreenName}ViewModel
fun ListTemplateScreen(
    viewModel: TemplateViewModel,
    onActions: (ListTemplateActions) -> Unit = {},
) {
    val search: String? by viewModel.search.collectAsState()
    val items: LazyPagingItems<TemplateModel> = viewModel.listTemplate.collectAsLazyPagingItems()
    val searchItems: LazyPagingItems<TemplateModel> = viewModel.searchListTemplate.collectAsLazyPagingItems()

    ListTemplateBody(
        search = search,
        items = items,
        searchItems = searchItems,
        onActions = onActions,
    )
}
