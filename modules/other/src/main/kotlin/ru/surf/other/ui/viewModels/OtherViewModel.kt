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
package ru.surf.other.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.surf.other.services.apiService.OtherApiService
import ru.surfstudio.android.logger.Logger
import ru.surfstudio.compose.response.extensions.done
import ru.surfstudio.compose.response.extensions.error
import ru.surfstudio.compose.response.extensions.success
import javax.inject.Inject

/**
 * [ViewModel] for module
 *
 * @property apiService service http query
 *
 * @author Vitaliy Zarubin
 */
@HiltViewModel
class OtherViewModel @Inject constructor(
    private val apiService: OtherApiService
) : ViewModel() {

    /**
     * [MutableStateFlow] for errors state
     */
    private val _commonError: MutableStateFlow<String?> = MutableStateFlow(null)

    /**
     * [StateFlow] for [_commonError]
     */
    val commonError: StateFlow<String?> get() = _commonError.asStateFlow()

    private val _commonSuccess: MutableStateFlow<Boolean?> = MutableStateFlow(null)

    /**
     * [StateFlow] for [_commonSuccess]
     */
    val commonSuccess: StateFlow<Boolean?> get() = _commonSuccess.asStateFlow()

    /**
     * [MutableStateFlow] for loading state
     */
    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_loading]
     */
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    /**
     * Clear state before query
     */
    private fun startQuery() {
        _commonSuccess.value = null
        _commonError.value = null
        _loading.value = true
    }

    /**
     * Query login user with callback if success
     *
     * @param email login user
     * @param pass it password
     * @param success callback if success with data user identifier and token
     */
    fun signIn(
        email: String,
        pass: String,
        success: (userId: String, token: String) -> Unit,
    ) {
        startQuery()
        viewModelScope.launch {
            apiService.signIn(email = email, pass = pass)
                .success {
                    success(it.user_id, it.token)
                }
                .error {
                    _commonError.value = it.message ?: "Authentication failed"
                    Logger.w(it)
                }
                .done { _loading.value = false }
        }
    }

    /**
     * Query validate user email for registration
     *
     * @param email login user
     */
    fun signUpValidate(email: String) {
        startQuery()
        viewModelScope.launch {
            apiService.signUpValidate(email = email)
                .success {
                    _commonSuccess.value = true
                    delay(500)
                    _commonSuccess.value = false
                }
                .error {
                    _commonError.value = it.message ?: "Authentication failed"
                    Logger.w(it)
                }
                .done { _loading.value = false }
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
     * @param success callback if success with data user identifier and token
     */
    fun signUp(
        email: String,
        pass: String,
        fname: String,
        lname: String,
        phoneWork: String,
        phoneHome: String,
        card: String,
        cvc: String,
        bio: String,
        success: (userId: String, token: String) -> Unit,
    ) {
        startQuery()
        viewModelScope.launch {
            apiService.signUp(
                email = email,
                pass = pass,
                fname = fname,
                lname = lname,
                phoneWork = phoneWork,
                phoneHome = phoneHome,
                card = card,
                cvc = cvc,
                bio = bio,
            )
                .success {
                    success(it.user_id, it.token)
                }
                .error {
                    _commonError.value = it.message ?: "Authentication failed"
                    Logger.w(it)
                }
                .done { _loading.value = false }
        }
    }
}
