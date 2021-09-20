package ru.surf.users.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse.executeWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.utils.ConstantsApp
import ru.surf.users.BuildConfig
import ru.surf.users.data.mappers.toModels
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.api.UsersApi

interface ApiServiceGet {

    val api: UsersApi

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
}