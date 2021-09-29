/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.ui.actions

import ru.surf.users.ui.screens.listUsers.ListUsersScreen

/**
 * Actions sealed class for screen [ListUsersScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class ListUsersActions {

    /**
     * Open main menu
     */
    object OpenMenu : ListUsersActions()

    /**
     * Find models by name
     *
     * @param text search text for query
     */
    class Search(val text: String?) : ListUsersActions()

    /**
     * Open page view user
     *
     * @param userId user identifier
     */
    class ToViewUser(val userId: String) : ListUsersActions()
}
