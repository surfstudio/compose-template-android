package ru.surf.template.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.surf.core.services.apiService.CoreApiService
import ru.surf.core.services.dataService.CoreDataService
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val api: CoreApiService,
    private val data: CoreDataService,
) : ViewModel() {

    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    val isLogin = flow {
        data.getSecurityModel().distinctUntilChanged().collect {
            emit(it != null)
            Timber.e("User status login: ${it != null}")
        }
    }

    init {
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
                    }
                }.error {
                    Timber.e(it)
                }
        }
    }
}
