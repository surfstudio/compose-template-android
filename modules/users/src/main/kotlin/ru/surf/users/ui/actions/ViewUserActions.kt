/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.ui.actions

sealed class ViewUserActions {
    data class RefreshView(val userId: String) : ViewUserActions()
}
