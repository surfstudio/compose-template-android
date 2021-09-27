/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val apiService: SettingsApiService,
    private val preferences: SettingsPreferences,
) : ViewModel() {

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    fun updateSettings() {
        _loading.value = true
        viewModelScope.launch {
            delay(1000)
            _loading.value = false
        }
    }
}
