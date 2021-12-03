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
package ru.surf.settings.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.surf.settings.data.preferences.SettingsPreferences
import ru.surf.settings.services.apiService.SettingsApiService
import javax.inject.Inject

/**
 * [ViewModel] for module
 *
 * @property apiService service http query
 * @property preferences service shared preference
 *
 * @author Vitaliy Zarubin
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val apiService: SettingsApiService,
    private val preferences: SettingsPreferences,
) : ViewModel() {

    /**
     * [MutableStateFlow] for loading state
     */
    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_loading]
     */
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    /**
     * Function stub as an example of how it works
     */
    fun updateSettings() {
        _loading.value = true
        viewModelScope.launch {
            delay(1000)
            _loading.value = false
        }
    }
}
