/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
