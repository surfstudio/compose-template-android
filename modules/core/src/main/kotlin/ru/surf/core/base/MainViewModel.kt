/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keygenqt.response.extensions.done
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.extension.withTransaction
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.core.interfaces.IAppPreferences
import ru.surf.core.services.apiService.CoreApiService
import ru.surf.core.services.dataService.CoreDataService
import timber.log.Timber
import javax.inject.Inject

/**
 * Main [ViewModel] for app
 *
 * @property apiService core service http query
 * @property dataService core service db room
 * @property dataServices group services db room
 * @property preferences group services shared preference
 *
 * @author Vitaliy Zarubin
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: CoreApiService,
    private val dataService: CoreDataService,
    private var dataServices: Set<@JvmSuppressWildcards IAppDatabase>,
    private var preferences: Set<@JvmSuppressWildcards IAppPreferences>,
) : ViewModel() {

    /**
     * [MutableStateFlow] for loading callbacks
     */
    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_loading]
     */
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    /**
     * [MutableStateFlow] for listen has network
     */
    private val _hasNetwork: MutableStateFlow<Boolean> = MutableStateFlow(true)

    /**
     * [StateFlow] for [_hasNetwork]
     */
    val hasNetwork: StateFlow<Boolean> get() = _hasNetwork.asStateFlow()

    /**
     * [MutableStateFlow] for start app and end splash
     */
    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_isReady]
     */
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    /**
     * Flow for listen change status user
     */
    val isLogin = flow {
        dataService.getSecurityModel().distinctUntilChanged().collect {
            emit(it != null)
            // clear data if logout
            if (it == null) {
                dataServices.forEach { service ->
                    service.clearCacheAfterLogout()
                }
                preferences.forEach { service ->
                    service.clearCacheAfterLogout()
                }
            }
        }
    }

    init {
        // update settings
        updateSettings()
        // common errors response UnknownHostException
        TryExecuteWithResponse.observeUnknownHostException(viewModelScope) {
            _hasNetwork.value = false
            _isReady.value = true
        }
    }

    /**
     * Update common for application settings
     */
    fun updateSettings() {
        _loading.value = true
        viewModelScope.launch {

            // listen settings
            dataService.getSettingsModel().onEach {
                Timber.e(it.toString())
            }.launchIn(viewModelScope)

            // update settings
            apiService.getListSettings()
                .success { models ->
                    dataService.withTransaction<CoreDataService> {
                        clearSettingsModel()
                        insertSettingsModel(*models.toTypedArray())
                        // Start app
                        _isReady.value = true
                        _hasNetwork.value = true
                    }
                }.error {
                    Timber.e(it)
                }
                .done {
                    _loading.value = false
                }
        }
    }

    /**
     * Update status user guest to member
     */
    fun login(userId: String, token: String) {
        viewModelScope.launch {
            dataService.withTransaction<CoreDataService> {
                clearSecurityModel()
                insertSecurityModel(
                    SecurityModel(
                        id = userId,
                        token = token
                    )
                )
            }
        }
    }

    /**
     * Logout user
     */
    fun logout() {
        viewModelScope.launch {
            dataService.withTransaction<CoreDataService> {
                clearSecurityModel()
            }
        }
    }
}
