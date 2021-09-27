/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.actions

sealed class SignInActions {
    data class SignIn(val email: String, val pass: String) : SignInActions()
}
