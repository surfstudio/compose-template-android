package ru.surf.users.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse.executeWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.surf.users.data.mappers.toModels
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.api.ApiUsers

interface ApiServiceGet {

    val api: ApiUsers

    suspend fun getListUsers(offset: Int, search: String? = null): ResponseResult<List<UserModel>> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.getListUsers(offset = offset, search = search)
                    .responseCheck()
                    .body()
                    ?.toModels()
                    ?: emptyList()
            }
        }
    }
}