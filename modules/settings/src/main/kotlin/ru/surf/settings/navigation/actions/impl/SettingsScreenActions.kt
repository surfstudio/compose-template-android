/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.settings.navigation.nav.SettingsNav

interface SettingsScreenActions {

    val controller: NavHostController

    fun toSettings() {
        controller.navigate(SettingsNav.MainNav.SettingsScreen.route)
    }
}
