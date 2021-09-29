/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.ui.actions

import ru.surf.settings.ui.screens.settings.SettingsScreen

/**
 * Actions sealed class for screen [SettingsScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class SettingsActions {

    /**
     * Action open menu
     */
    object OpenMenu : SettingsActions()

    /**
     * Action call update settings
     */
    object UpdateSettings : SettingsActions()
}
