/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.users.navigation.nav.UsersNav
import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.screens.viewUser.ViewUserScreen

/**
 * Custom actions for [ListUsersScreen], [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
interface UsersScreenActions {

    val controller: NavHostController

    fun toUsers() {
        controller.navigate(UsersNav.MainNav.ListUsersNavScreen.route)
    }

    fun toUser(userId: String) {
        UsersNav.MainNav.ViewUserNavScreen.apply {
            controller.navigate(getRoute(userId))
        }
    }
}
