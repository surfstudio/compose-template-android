package ru.surf.users.services.apiService

import ru.surf.users.services.api.ApiUsers
import ru.surf.users.services.apiService.impl.*

class UsersApiService(
    override val api: ApiUsers,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut