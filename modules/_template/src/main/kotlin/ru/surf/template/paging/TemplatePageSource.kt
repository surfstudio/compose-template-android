/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.keygenqt.response.extensions.pagingSucceeded
import ru.surf.core.utils.ConstantsPaging
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.services.apiService.TemplateApiService

// @todo {ModelName}PageSource
// @todo {ModuleName}ApiService
// @todo {ModelName}Model
class TemplatePageSource(
    private val search: String?,
    private val apiService: TemplateApiService,
) : PagingSource<Int, TemplateModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TemplateModel> {
        val offset = params.key ?: 0
        if (search == null) {
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null,
            )
        }
        return apiService.getListTemplate(search = search, offset = offset).pagingSucceeded { data ->
            LoadResult.Page(
                data = data,
                prevKey = if (offset == 0) null else offset,
                nextKey = if (data.isEmpty()) null else offset + ConstantsPaging.PAGE_LIMIT
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TemplateModel>): Int {
        return 0
    }
}
