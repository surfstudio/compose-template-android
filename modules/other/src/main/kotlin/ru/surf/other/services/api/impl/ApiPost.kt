package ru.surf.other.services.api.impl

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.surf.other.data.requests.SignInRequest
import ru.surf.other.data.responses.SignInResponse

interface ApiPost {
    @POST("login")
    suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>

    @POST("login_error") // @todo just for example error
    suspend fun signInError(@Body request: SignInRequest): Response<SignInResponse>
}