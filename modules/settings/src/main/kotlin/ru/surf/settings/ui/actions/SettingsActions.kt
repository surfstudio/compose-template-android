/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.ui.actions

sealed class SettingsActions {
    object OpenMenu : SettingsActions()
    object UpdateSettings : SettingsActions()
}
