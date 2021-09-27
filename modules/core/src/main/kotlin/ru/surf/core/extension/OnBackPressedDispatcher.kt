/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.extension

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun OnBackPressedDispatcher.EmitByStatus(status: Boolean, emit: () -> Unit) {
    val closeNavigatorButton = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                emit.invoke()
            }
        }
    }
    LaunchedEffect(status) {
        closeNavigatorButton.remove()
        closeNavigatorButton.isEnabled = status
        addCallback(closeNavigatorButton)
    }
}
