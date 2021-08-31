package ru.surf.users.services.apiService.impl

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.users.BuildConfig
import ru.surf.users.base.ResponseResult
import ru.surf.users.base.executeWithResponse
import ru.surf.users.data.mappers.toModels
import ru.surf.users.data.models.UserModel
import ru.surf.users.data.responses.UserResponse
import ru.surf.users.utils.ConstantsApp
import ru.surf.users.utils.ConstantsPaging.PAGE_LIMIT

interface ApiServiceGet {

    val httpClient: HttpClient

    suspend fun getListUsers(offset: Int, search: String? = null): ResponseResult<List<UserModel>> {
        return withContext(Dispatchers.IO) {
            if (BuildConfig.DEBUG) delay(1000L) // Simulate slow internet
            executeWithResponse {
                httpClient.get<List<UserResponse>>("${ConstantsApp.API_URL}/chats") {
                    search?.let { parameter("search", search) }
                    parameter("offset", offset)
                    parameter("limit", PAGE_LIMIT)
                }.toModels()
            }
        }
    }
}