package ru.surf.users.ui.actions

sealed class ListUsersActions {
    class Search(val text: String?) : ListUsersActions()
    class ToViewUser(val userId: String) : ListUsersActions()
}