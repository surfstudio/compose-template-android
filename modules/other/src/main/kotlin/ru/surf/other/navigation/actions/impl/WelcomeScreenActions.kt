/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.other.navigation.nav.OtherNav
import ru.surf.other.ui.screens.welcome.WelcomeScreen

/**
 * Custom actions for [WelcomeScreen]
 *
 * @author Vitaliy Zarubin
 */
interface WelcomeScreenActions {

    val controller: NavHostController

    fun toSignIn() {
        controller.navigate(OtherNav.SignInNav.SignInNavScreen.route)
    }

    fun toSignUp() {
        controller.navigate(OtherNav.SignUpNav.SignUpNavScreen.route)
    }
}
