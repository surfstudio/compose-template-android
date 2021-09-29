/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.services.apiService

import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.impl.*

/**
 * Base services for query separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
class UsersApiService(
    override val api: UsersApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
