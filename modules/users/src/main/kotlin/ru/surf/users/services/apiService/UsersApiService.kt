package ru.surf.users.services.apiService

import io.ktor.client.*
import ru.surf.users.services.apiService.impl.*

class UsersApiService(
    override val httpClient: HttpClient,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut