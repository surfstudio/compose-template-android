package ru.surf.users.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ru.surf.users.base.*
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import ru.surf.users.utils.ConstantsPaging.CACHE_TIMEOUT
import timber.log.Timber
import kotlin.math.roundToInt

@OptIn(ExperimentalPagingApi::class)
class UsersRemoteMediator(
    private val data: UsersDataService,
    private val apiService: UsersApiService,
) : RemoteMediator<Int, UserModel>() {

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

            val page = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> (data.countUserModel() / state.config.pageSize.toFloat())
                    .roundToInt()
                    .plus(1)
            }

            val response = apiService.getListUsers(
                offset = page ?: 0
            )

            response.success { models ->
                data.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        preferences.lastUpdateListUsers = System.currentTimeMillis()
                        clearUserModel()
                    }
                    if (!response.isEndDouble(state.lastItemOrNull()?.id) || loadType != LoadType.APPEND) {
                        insertUserModel(*models.toTypedArray())
                    }
                }
            }.error {
                Timber.e(it)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isError
                        || response.isEmpty
                        || response.isEndDouble(state.lastItemOrNull()?.id)
            )

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}