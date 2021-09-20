package ru.surf.other.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.utils.ConstantsApp
import ru.surf.other.BuildConfig
import ru.surf.other.data.requests.SignInRequest
import ru.surf.other.data.responses.SignInResponse
import ru.surf.other.services.api.OtherApi

interface ApiServicePost {

    val api: OtherApi

    suspend fun signIn(email: String, pass: String): ResponseResult<SignInResponse> {
        return withContext(Dispatchers.IO) {
            LocalTryExecuteWithResponse.executeWithResponse {

                if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet

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
}