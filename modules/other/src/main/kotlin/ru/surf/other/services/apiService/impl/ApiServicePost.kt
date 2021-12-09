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
package ru.surf.other.services.apiService.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.utils.ConstantsApp
import ru.surf.core.utils.HelperApp
import ru.surf.other.BuildConfig
import ru.surf.other.data.requests.SignInRequest
import ru.surf.other.data.requests.SignUpRequest
import ru.surf.other.data.requests.SignUpValidateRequest
import ru.surf.other.data.responses.SignInResponse
import ru.surf.other.data.responses.SignUpResponse
import ru.surf.other.data.responses.SignUpValidateResponse
import ru.surf.other.services.api.OtherApi
import ru.surfstudio.compose.response.LocalTryExecuteWithResponse
import ru.surfstudio.compose.response.ResponseResult
import ru.surfstudio.compose.response.extensions.responseCheck

/**
 * The POST method is used to submit an entity to the specified resource, often causing a change in state or side effects on the server.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServicePost {

    val api: OtherApi

    /**
     * Query login user with callback if success. For example use random query with error response.
     *
     * @param email login user
     * @param pass it password
     *
     * @return response for get userId and token
     */
    suspend fun signIn(email: String, pass: String): ResponseResult<SignInResponse> {
        return withContext(Dispatchers.IO) {
            LocalTryExecuteWithResponse.executeWithResponse {

                // Simulate slow internet
                if (BuildConfig.DEBUG && HelperApp.isNotRunningTest) delay(ConstantsApp.DEBUG_DELAY)

                val request = SignInRequest(
                    username = email,
                    password = pass,
                )

                // @todo just for example error
                listOf(api.signIn(request), api.signInError(request))[(0..1).random()]
                    .responseCheck()
                    .body()!!
            }
        }
    }

    /**
     * Query validate user email for registration
     *
     * @param email login user
     *
     * @return response for check is success validate
     */
    suspend fun signUpValidate(email: String): ResponseResult<SignUpValidateResponse> {
        return withContext(Dispatchers.IO) {
            LocalTryExecuteWithResponse.executeWithResponse {

                // Simulate slow internet
                if (BuildConfig.DEBUG && HelperApp.isNotRunningTest) delay(ConstantsApp.DEBUG_DELAY)

                api.signUpValidate(
                    SignUpValidateRequest(
                        email = email
                    )
                ).responseCheck()
                    .body()!!
            }
        }
    }

    /**
     * Query registration
     *
     * @param email login email user
     * @param pass just password
     * @param fname string name user
     * @param lname string surname user
     * @param phoneWork string phone from work
     * @param phoneHome string phone form home
     * @param card string format ####-####-####-####
     * @param cvc string format ###
     * @param bio text about user
     *
     * @return response for get userId and token
     */
    suspend fun signUp(
        email: String,
        pass: String,
        fname: String,
        lname: String,
        phoneWork: String,
        phoneHome: String,
        card: String,
        cvc: String,
        bio: String,
    ): ResponseResult<SignUpResponse> {
        return withContext(Dispatchers.IO) {
            LocalTryExecuteWithResponse.executeWithResponse {

                // Simulate slow internet
                if (BuildConfig.DEBUG && HelperApp.isNotRunningTest) delay(ConstantsApp.DEBUG_DELAY)

                api.signUp(
                    SignUpRequest(
                        email = email,
                        password = pass,
                        fname = fname,
                        lname = lname,
                        phoneWork = phoneWork,
                        phoneHome = phoneHome,
                        card = card,
                        cvc = cvc,
                        bio = bio,
                    )
                ).responseCheck()
                    .body()!!
            }
        }
    }
}
