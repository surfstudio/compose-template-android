package ru.surf.other.services.api.impl

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.surf.other.data.responses.LoginResponse

interface ApiGet {
    @GET("login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<LoginResponse>
}