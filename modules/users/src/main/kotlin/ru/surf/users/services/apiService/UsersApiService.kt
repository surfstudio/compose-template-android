package ru.surf.users.services.apiService

import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.impl.*

class UsersApiService(
    override val api: UsersApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut