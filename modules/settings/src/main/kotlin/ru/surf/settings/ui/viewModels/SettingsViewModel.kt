package ru.surf.settings.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.surf.settings.data.preferences.SettingsPreferences
import ru.surf.settings.services.apiService.SettingsApiService
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val apiService: SettingsApiService,
    private val preferences: SettingsPreferences,
) : ViewModel()
