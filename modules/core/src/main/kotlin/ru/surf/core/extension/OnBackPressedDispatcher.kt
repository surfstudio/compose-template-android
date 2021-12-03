/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.core.extension

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

/**
 * Listen status for enable [OnBackPressedCallback]
 *
 * @param status state enable handleOnBackPressed
 * @param emit lambda for emit is enable
 *
 * @sample ru.surf.template.drawer.SetBackDispatcherAppDrawer
 *
 * @author Vitaliy Zarubin
 */
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
