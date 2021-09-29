/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import ru.surf.other.ui.screens.welcome.WelcomeScreen

/**
 * Routing for [WelcomeScreen]
 *
 * @author Vitaliy Zarubin
 */
object WelcomeNavScreen {
    val WelcomeNavScreen = object : NavScreen {
        override val route: String = "WelcomeScreen"
    }
}
