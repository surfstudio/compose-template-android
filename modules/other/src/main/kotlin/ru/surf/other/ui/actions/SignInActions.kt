/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.actions

import ru.surf.other.ui.screens.signIn.SignInScreen

/**
 * Actions sealed class for screen [SignInScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class SignInActions {

    /**
     * Login action
     *
     * @property email user login
     * @property pass just password
     */
    data class SignIn(val email: String, val pass: String) : SignInActions()
}
