/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.actions

sealed class WelcomeActions {
    object ToSignIn : WelcomeActions()
    object ToSignUp : WelcomeActions()
}
