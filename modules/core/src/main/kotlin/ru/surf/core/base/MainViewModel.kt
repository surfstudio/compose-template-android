package ru.surf.core.base

import androidx.lifecycle.viewModelScope
import com.keygenqt.response.extensions.done
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.services.apiService.CoreApiService
import ru.surf.core.services.dataService.CoreDataService
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: CoreApiService,
    private val data: CoreDataService,
) : AppViewModel() {

    override fun tryExecuteWithResponse(exception: Exception) {
        if (exception is UnknownHostException) {
            _hasNetwork.value = false
            _isReady.value = true
        }
    }

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    private val _hasNetwork: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val hasNetwork: StateFlow<Boolean> get() = _hasNetwork.asStateFlow()

    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    val isLogin = flow {
        data.getSecurityModel().distinctUntilChanged().collect {
            LocalUserChangeStatus.changeStatus(it != null)
            emit(it != null)
        }
    }

    init {
        updateSettings()
    }

    fun updateSettings() {
        _loading.value = true
        viewModelScope.launch {

            // listen settings
            data.getSettingsModel().onEach {
                Timber.e(it.toString())
            }.launchIn(viewModelScope)

            // update settings
            api.getListSettings()
                .success { models ->
                    data.withTransaction {
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

    fun login(userId: String, token: String) {
        viewModelScope.launch {
            data.withTransaction {
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

    fun logout() {
        viewModelScope.launch {
            data.withTransaction {
                clearSecurityModel()
            }
        }
    }
}
