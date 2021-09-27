/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.apiService

import ru.surf.core.services.api.CoreApi
import ru.surf.core.services.apiService.impl.*

class CoreApiService(
    override val api: CoreApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
