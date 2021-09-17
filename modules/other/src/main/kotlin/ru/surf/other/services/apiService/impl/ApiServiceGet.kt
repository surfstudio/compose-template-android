package ru.surf.other.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse.executeWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.surf.other.services.api.OtherApi

interface ApiServiceGet {

    val api: OtherApi

    suspend fun login(email: String, password: String): ResponseResult<Boolean> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.login(email = email, password = password)
                    .responseCheck()
                    .body()
                    ?.token?.isNotBlank()
                    ?: false
            }
        }
    }
}