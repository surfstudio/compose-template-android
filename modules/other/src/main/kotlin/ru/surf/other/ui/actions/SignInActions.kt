package ru.surf.other.ui.actions

sealed class SignInActions {
    data class SignIn(val email: String, val pass: String) : SignInActions()
}