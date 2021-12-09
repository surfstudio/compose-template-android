/**
 * Copyright 2021 Surf LLC
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
package ru.surf.users.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.surf.core.utils.ConstantsPaging
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.apiService.UsersApiService
import ru.surfstudio.compose.response.ResponseResult

/**
 * Paging list without room cache [PagingSource]
 *
 * @param search string query to back-end
 * @param apiService query service module
 *
 * @author Vitaliy Zarubin
 * @see <a href="https://developer.android.com/reference/kotlin/androidx/paging/PagingSource">PagingSource</a>
 */
class UsersPageSource(
    private val search: String?,
    private val apiService: UsersApiService,
) : PagingSource<Int, UserModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        val offset = params.key ?: 0
        if (search == null) {
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null,
            )
        }

        // not work with mock - 400 error... should be empty
        // return apiService.getListUsers(search = search, offset = offset).pagingSucceeded { data ->
        //     LoadResult.Page(
        //         data = data,
        //         prevKey = if (offset == 0) null else offset,
        //         nextKey = if (data.isEmpty()) null else offset + ConstantsPaging.PAGE_LIMIT
        //     )
        // }

        // fix for mock
        return apiService.getListUsers(search = search, offset = offset).let {
            if (it is ResponseResult.Success) {
                LoadResult.Page(
                    data = it.data,
                    prevKey = if (offset == 0) null else offset,
                    nextKey = if (it.data.isEmpty()) null else offset + ConstantsPaging.PAGE_LIMIT
                )
            } else {
                LoadResult.Page(
                    data = listOf(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int {
        return 0
    }
}
