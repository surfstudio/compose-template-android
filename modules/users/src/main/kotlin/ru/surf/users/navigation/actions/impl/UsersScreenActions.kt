/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.users.navigation.nav.UsersNav

interface UsersScreenActions {

    val controller: NavHostController

    fun toUsers() {
        controller.navigate(UsersNav.MainNav.ListUsersScreen.route)
    }

    fun toUser(userId: String) {
        UsersNav.MainNav.ViewUserScreen.apply {
            controller.navigate(getRoute(userId))
        }
    }
}
