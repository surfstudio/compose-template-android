package ru.surf.core.base

import com.keygenqt.response.LocalTryExecuteWithResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.net.UnknownHostException

class TryExecuteWithResponse {
    companion object {
        fun observeUnknownHostException(scope: CoroutineScope, body: () -> Unit) {
            LocalTryExecuteWithResponse.current.onEach { exception ->
                if (exception is UnknownHostException) {
                    body.invoke()
                }
            }.launchIn(scope)
        }
    }
}