/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
