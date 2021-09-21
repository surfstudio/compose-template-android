package ru.surf.other.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keygenqt.response.extensions.done
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.surf.other.services.apiService.OtherApiService
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class OtherViewModel @Inject constructor(
    private val apiService: OtherApiService
) : ViewModel() {

    private val _commonError: MutableStateFlow<String?> = MutableStateFlow(null)
    val commonError: StateFlow<String?> get() = _commonError.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    fun signIn(
        email: String,
        pass: String,
        success: (userId: String, token: String) -> Unit,
    ) {
        _commonError.value = null
        _loading.value = true
        viewModelScope.launch {
            apiService.signIn(email = email, pass = pass)
                .success {
                    success(it.user_id, it.token)
                }
                .error {
                    _commonError.value = it.message ?: "Authentication failed";
                    Timber.e(it)
                }
                .done { _loading.value = false }
        }
    }
}
