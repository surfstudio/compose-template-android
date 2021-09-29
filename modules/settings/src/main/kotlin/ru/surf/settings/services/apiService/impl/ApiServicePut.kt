/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.services.apiService.impl

import ru.surf.settings.services.api.SettingsApi

/**
 * The PUT method replaces all current representations of the target resource with the request payload.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServicePut {
    val api: SettingsApi
}
