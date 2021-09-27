/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.api.impl

import retrofit2.Response
import retrofit2.http.GET
import ru.surf.core.data.responses.SettingsResponse

interface ApiGet {
    @GET("settings")
    suspend fun getListSettings(): Response<List<SettingsResponse>>
}
