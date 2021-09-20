package ru.surf.core.base

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object LocalUserChangeStatus {

    private val userStatus: MutableSharedFlow<Boolean> = MutableSharedFlow(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val current: SharedFlow<Boolean>
        get() = userStatus.asSharedFlow()

    fun changeStatus(isLogin: Boolean) {
        userStatus.tryEmit(isLogin)
    }
}