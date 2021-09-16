package ru.surf.users.ui.actions

sealed class UsersActions {
    class Search(val text: String?) : UsersActions()
}