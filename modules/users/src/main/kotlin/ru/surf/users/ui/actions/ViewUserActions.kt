package ru.surf.users.ui.actions

sealed class ViewUserActions {
    data class RefreshView(val userId: String) : ViewUserActions()
}