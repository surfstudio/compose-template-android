package ru.surf.users.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.users.navigation.nav.UsersNav

interface UsersScreenActions {

    val controller: NavHostController

    fun navigateToUsers() {
        controller.navigate(UsersNav.MainNav.ListUsersScreen.route)
    }
}