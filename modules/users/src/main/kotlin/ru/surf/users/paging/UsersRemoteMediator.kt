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

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ru.surf.core.extension.withTransaction
import ru.surf.core.utils.ConstantsPaging.CACHE_TIMEOUT
import ru.surf.core.utils.ConstantsPaging.PAGE_LIMIT
import ru.surf.users.data.models.UserModel
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import ru.surfstudio.android.logger.Logger
import ru.surfstudio.compose.response.extensions.error
import ru.surfstudio.compose.response.extensions.isEmpty
import ru.surfstudio.compose.response.extensions.isError
import ru.surfstudio.compose.response.extensions.success

/**
 * Paging list with room cache [RemoteMediator]
 *
 * @param apiService query service module
 * @param dataService service room db
 * @param preferences service shared preferences
 *
 * @author Vitaliy Zarubin
 * @see <a href="https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator">RemoteMediator</a>
 */
@OptIn(ExperimentalPagingApi::class)
class UsersRemoteMediator(
    private val apiService: UsersApiService,
    private val dataService: UsersDataService,
    private val preferences: UsersPreferences,
) : RemoteMediator<Int, UserModel>() {

    /**
     * Static key for offset-limit paging
     */
    companion object {
        var key: Int? = null
    }

    /**
     * Timeout cache for refresh list at start
     */
    override suspend fun initialize(): InitializeAction {
        return if (System.currentTimeMillis() - preferences.lastUpdateListUsers >= CACHE_TIMEOUT) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    /**
     * Base logic
     */
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
                Logger.w(it)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isError || response.isEmpty
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
