/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.ui.actions

import ru.surf.users.ui.screens.viewUser.ViewUserScreen

/**
 * Actions sealed class for screen [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class ViewUserActions {

    /**
     * Update model data on page and db
     *
     * @param userId user identifier
     */
    data class RefreshView(val userId: String) : ViewUserActions()
}
