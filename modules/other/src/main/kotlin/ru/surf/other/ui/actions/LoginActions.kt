package ru.surf.other.ui.actions

sealed class LoginActions {
    class Search(val text: String?) : LoginActions()
}