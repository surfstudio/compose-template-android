/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.services.api.impl

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.surf.other.data.requests.SignInRequest
import ru.surf.other.data.requests.SignUpRequest
import ru.surf.other.data.requests.SignUpValidateRequest
import ru.surf.other.data.responses.SignInResponse
import ru.surf.other.data.responses.SignUpResponse
import ru.surf.other.data.responses.SignUpValidateResponse

/**
 * The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.
 *
 * @author Vitaliy Zarubin
 */
interface ApiPost {

    @POST("login_error") // @todo just for example error
    suspend fun signInError(@Body request: SignInRequest): Response<SignInResponse>

    @POST("login")
    suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>

    @POST("email_validate")
    suspend fun signUpValidate(@Body request: SignUpValidateRequest): Response<SignUpValidateResponse>

    @POST("registration")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>
}
