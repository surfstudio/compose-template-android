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
package ru.surf.other.ui.screens.welcome

import androidx.compose.runtime.Composable
import ru.surf.other.ui.actions.WelcomeActions
import ru.surf.other.ui.viewModels.OtherViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun WelcomeScreen(
    viewModel: OtherViewModel,
    onActions: (WelcomeActions) -> Unit = {},
) {
    WelcomeBody(
        onActions = onActions,
    )
}
