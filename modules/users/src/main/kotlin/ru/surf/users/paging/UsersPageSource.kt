package ru.surf.users.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.surf.users.base.pagingSucceeded
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.utils.ConstantsPaging

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
        return apiService.getListUsers(search = search, offset = offset).pagingSucceeded { data ->
            LoadResult.Page(
                data = data,
                prevKey = if (offset == 0) null else offset,
                nextKey = if (data.isEmpty()) null else offset + ConstantsPaging.PAGE_LIMIT
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int {
        return 0
    }
}