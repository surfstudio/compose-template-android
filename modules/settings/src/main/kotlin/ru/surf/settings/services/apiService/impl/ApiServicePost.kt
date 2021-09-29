/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.services.apiService.impl

import ru.surf.settings.services.api.SettingsApi

/**
 * The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServicePost {
    val api: SettingsApi
}
