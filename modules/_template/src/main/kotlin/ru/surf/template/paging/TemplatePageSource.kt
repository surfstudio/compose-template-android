/**
 * Copyright 2021 Surf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
