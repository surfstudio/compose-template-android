/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import ru.surf.settings.ui.screens.settings.SettingsScreen

/**
 * Routing for [SettingsScreen]
 *
 * @author Vitaliy Zarubin
 */
object SettingsScreen {
    val SettingsNavScreen = object : NavScreen {
        override val route: String = "SettingsScreen"
    }
}
