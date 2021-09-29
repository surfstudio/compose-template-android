/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.settings.ui.screens.settings.SettingsScreen

/**
 * Custom actions for [SettingsScreen]
 *
 * @author Vitaliy Zarubin
 */
interface SettingsScreenActions {

    val controller: NavHostController

    fun toSettings() {
        controller.navigate(SettingsNav.MainNav.SettingsNavScreen.route)
    }
}
