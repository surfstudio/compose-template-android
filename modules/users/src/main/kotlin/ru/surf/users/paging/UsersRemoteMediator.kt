package ru.surf.users.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.keygenqt.response.error
import com.keygenqt.response.isEmpty
import com.keygenqt.response.isError
import com.keygenqt.response.success
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import ru.surf.users.utils.ConstantsPaging.CACHE_TIMEOUT
import ru.surf.users.utils.ConstantsPaging.PAGE_LIMIT
import timber.log.Timber

@OptIn(ExperimentalPagingApi::class)
class UsersRemoteMediator(
    private val data: UsersDataService,
    private val apiService: UsersApiService,
) : RemoteMediator<Int, UserModel>() {

    companion object {
        var key: Int? = null
    }

    override suspend fun initialize(): InitializeAction {
        return if (System.currentTimeMillis() - data.preferences.lastUpdateListUsers >= CACHE_TIMEOUT) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserModel>,
    ): MediatorResult {
        return try {

            val offset = when (loadType) {
                LoadType.REFRESH -> {
                    key = null
                    key
                }
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    key = (key ?: 0).plus(1)
                    key
                }
            }

            val response = apiService.getListUsers(
                offset = (offset ?: 0) * PAGE_LIMIT
            )

            response.success { models ->
                data.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        preferences.lastUpdateListUsers = System.currentTimeMillis()
                        clearUserModel()
                    }
                    insertUserModel(*models.toTypedArray())
                }
            }.error {
                Timber.e(it)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isError || response.isEmpty
            )

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}