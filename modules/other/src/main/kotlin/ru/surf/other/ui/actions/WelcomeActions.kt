/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.actions

import ru.surf.other.ui.screens.welcome.WelcomeScreen

/**
 * Actions sealed class for screen [WelcomeScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class WelcomeActions {

    /**
     * Action for navigation to page SignIn
     */
    object ToSignIn : WelcomeActions()

    /**
     * Action for navigation to page SignUp
     */
    object ToSignUp : WelcomeActions()
}
