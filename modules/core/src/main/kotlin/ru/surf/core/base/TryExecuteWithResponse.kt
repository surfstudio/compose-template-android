/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import com.keygenqt.response.LocalTryExecuteWithResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.net.UnknownHostException

/**
 * Observe for specific exceptions
 *
 * @author Vitaliy Zarubin
 */
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
