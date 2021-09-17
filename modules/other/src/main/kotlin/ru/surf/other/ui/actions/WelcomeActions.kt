package ru.surf.other.ui.actions

sealed class WelcomeActions {
    object ToSignIn : WelcomeActions()
    object ToSignUp : WelcomeActions()
}