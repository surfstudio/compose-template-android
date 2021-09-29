/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.services.apiService.impl

import ru.surf.settings.services.api.SettingsApi

/**
 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServiceGet {
    val api: SettingsApi
}
