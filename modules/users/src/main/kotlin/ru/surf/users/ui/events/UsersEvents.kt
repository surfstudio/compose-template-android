package ru.surf.users.ui.events

sealed class UsersEvents {
    class Search(val text: String?) : UsersEvents()
}