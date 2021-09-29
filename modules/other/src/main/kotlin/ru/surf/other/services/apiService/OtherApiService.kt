/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.services.apiService

import ru.surf.other.services.api.OtherApi
import ru.surf.other.services.apiService.impl.*

/**
 * Base services for query separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
class OtherApiService(
    override val api: OtherApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
