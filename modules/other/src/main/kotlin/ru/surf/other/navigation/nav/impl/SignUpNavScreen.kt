/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import ru.surf.other.ui.screens.signUp.SignUpScreen

/**
 * Routing for [SignUpScreen]
 *
 * @author Vitaliy Zarubin
 */
object SignUpNavScreen {
    val SignUpNavScreen = object : NavScreen {
        override val route: String = "SignUpNavScreen"
    }
}
