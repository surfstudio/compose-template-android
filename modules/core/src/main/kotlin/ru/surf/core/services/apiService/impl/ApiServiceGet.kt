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
package ru.surf.core.services.apiService.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.BuildConfig
import ru.surf.core.data.mappers.toModels
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.services.api.CoreApi
import ru.surf.core.utils.ConstantsApp
import ru.surf.core.utils.HelperApp
import ru.surfstudio.compose.response.LocalTryExecuteWithResponse
import ru.surfstudio.compose.response.ResponseResult
import ru.surfstudio.compose.response.extensions.responseCheck

/**
 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServiceGet {

    val api: CoreApi

    /**
     * Get list settings from back-end
     */
    suspend fun getListSettings(): ResponseResult<List<SettingsModel>> {
        return withContext(Dispatchers.IO) {

            // Simulate slow internet
            if (BuildConfig.DEBUG && HelperApp.isNotRunningTest) delay(ConstantsApp.DEBUG_DELAY)

            LocalTryExecuteWithResponse.executeWithResponse {
                api.getListSettings()
                    .responseCheck()
                    .body()
                    ?.toModels()
                    ?: emptyList()
            }
        }
    }
}
