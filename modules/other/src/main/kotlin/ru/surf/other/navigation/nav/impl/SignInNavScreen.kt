/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import ru.surf.other.ui.screens.signIn.SignInScreen

/**
 * Routing for [SignInScreen]
 *
 * @author Vitaliy Zarubin
 */
object SignInNavScreen {
    val SignInNavScreen = object : NavScreen {
        override val route: String = "SignInNavScreen"
    }
}
