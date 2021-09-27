/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.isEmpty
import com.keygenqt.response.extensions.isError
import com.keygenqt.response.extensions.success
import ru.surf.core.extension.withTransaction
import ru.surf.core.utils.ConstantsPaging.CACHE_TIMEOUT
import ru.surf.core.utils.ConstantsPaging.PAGE_LIMIT
import ru.surf.users.data.models.UserModel
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import timber.log.Timber

@OptIn(ExperimentalPagingApi::class)
class UsersRemoteMediator(
    private val apiService: UsersApiService,
    private val dataService: UsersDataService,
    private val preferences: UsersPreferences,
) : RemoteMediator<Int, UserModel>() {

    companion object {
        var key: Int? = null
    }

    override suspend fun initialize(): InitializeAction {
        return if (System.currentTimeMillis() - preferences.lastUpdateListUsers >= CACHE_TIMEOUT) {
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
                dataService.withTransaction<UsersDataService> {
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
