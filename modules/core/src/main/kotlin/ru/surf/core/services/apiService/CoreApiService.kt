/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.apiService

import ru.surf.core.services.api.CoreApi
import ru.surf.core.services.apiService.impl.*

/**
 * Base services for query separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
class CoreApiService(
    override val api: CoreApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
