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
package ru.surf.core.ui.screens.status

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.MainViewModel
import ru.surf.core.ui.actions.UnknownHostActions

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun StatusScreen(
    viewModel: MainViewModel,
    onActions: (UnknownHostActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()
    val hasNetwork: Boolean by viewModel.hasNetwork.collectAsState()

    if (!hasNetwork) {
        UnknownHostBody(
            loading = loading,
            onActions = onActions,
        )
    }
}
