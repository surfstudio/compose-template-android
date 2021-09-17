package ru.surf.other.ui.actions

sealed class SignUpActions {
    data class SignUp(val email: String, val pass: String) : SignUpActions()
}