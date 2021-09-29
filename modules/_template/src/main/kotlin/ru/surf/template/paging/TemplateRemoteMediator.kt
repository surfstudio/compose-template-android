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
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.data.preferences.TemplatePreferences
import ru.surf.template.services.apiService.TemplateApiService
import ru.surf.template.services.dataService.TemplateDataService
import timber.log.Timber

@OptIn(ExperimentalPagingApi::class)
// @todo {ModelName}RemoteMediator
// @todo {ModuleName}DataService
// @todo {ModuleName}ApiService
// @todo {ModelName}Model
class TemplateRemoteMediator(
    private val apiService: TemplateApiService,
    private val dataService: TemplateDataService,
    private val preferences: TemplatePreferences,
) : RemoteMediator<Int, TemplateModel>() {

    companion object {
        var key: Int? = null
    }

    override suspend fun initialize(): InitializeAction {
        return if (System.currentTimeMillis() - preferences.lastUpdateListTemplate >= CACHE_TIMEOUT) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TemplateModel>,
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

            val response = apiService.getListTemplate(
                offset = (offset ?: 0) * PAGE_LIMIT
            )

            response.success { models ->
                dataService.withTransaction<TemplateDataService> {
                    if (loadType == LoadType.REFRESH) {
                        preferences.lastUpdateListTemplate = System.currentTimeMillis()
                        clearTemplateModel()
                    }
                    insertTemplateModel(*models.toTypedArray())
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
