/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.services.apiService

import ru.surf.settings.services.api.SettingsApi
import ru.surf.settings.services.apiService.impl.*

/**
 * Base services for query separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
class SettingsApiService(
    override val api: SettingsApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
