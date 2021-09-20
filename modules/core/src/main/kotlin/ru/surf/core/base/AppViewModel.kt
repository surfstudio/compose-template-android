package ru.surf.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keygenqt.response.LocalTryExecuteWithResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class AppViewModel : ViewModel() {

    open fun clearAfterLogout() {}

    open fun tryExecuteWithResponse(exception: Exception) {}

    companion object {
        var subscribeClear = mutableSetOf<KClass<*>>()
    }

    init {
        if (!subscribeClear.contains(this::class)) {
            subscribeClear.add(this::class)
            viewModelScope.launch {
                LocalTryExecuteWithResponse.current.collect {
                    delay(10)
                    tryExecuteWithResponse(it)
                }
            }
            viewModelScope.launch {
                LocalUserChangeStatus.current.collect {
                    if (!it) {
                        delay(10)
                        clearAfterLogout()
                    }
                }
            }
        }
    }
}