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
package ru.surf.users.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse.executeWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.utils.ConstantsApp
import ru.surf.users.BuildConfig
import ru.surf.users.data.mappers.toModel
import ru.surf.users.data.mappers.toModels
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.api.UsersApi

/**
 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServiceGet {

    val api: UsersApi

    /**
     * Get list models [UserModel]
     *
     * @param offset mysql offset
     * @param search find models by name
     */
    suspend fun getListUsers(offset: Int, search: String? = null): ResponseResult<List<UserModel>> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
                api.getListUsers(offset = offset, search = search)
                    .responseCheck()
                    .body()
                    ?.toModels()
                    ?: emptyList()
            }
        }
    }

    /**
     * Update view with model [UserModel]
     *
     * @param userId string user identifier
     */
    suspend fun updateUser(userId: String): ResponseResult<UserModel> {
        return withContext(Dispatchers.IO) {
            if (ru.surf.core.BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
            executeWithResponse {
                api.updateUser(userId)
                    .responseCheck()
                    .body()
                    ?.toModel()!!
            }
        }
    }
}
