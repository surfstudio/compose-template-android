package ru.surf.settings.ui.actions

sealed class SettingsActions {
    object OpenMenu : SettingsActions()
    object UpdateSettings : SettingsActions()
}