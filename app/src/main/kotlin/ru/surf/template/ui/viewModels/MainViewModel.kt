package ru.surf.template.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.services.dataService.CoreDataService
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val data: CoreDataService,
) : ViewModel() {

    private val userId = "USER-ID 1"

    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    init {
        viewModelScope.launch {

            // listen flow
            data.getSecurityModel(userId).onEach {
                Timber.e(it.toString())
            }.launchIn(viewModelScope)

            // Hold a little splash
            delay(500)

            // test security db
            data.withTransaction {
                data.insertSecurityModel(
                    SecurityModel(
                        id = userId,
                        token = UUID.randomUUID().toString(),
                        isLogin = true,
                    )
                )
            }

            // Start app
            _isReady.value = true
        }
    }
}
