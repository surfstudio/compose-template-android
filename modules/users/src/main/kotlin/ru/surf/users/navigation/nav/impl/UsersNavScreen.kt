/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import com.keygenqt.routing.NavScreenWithArgument
import ru.surf.users.ui.screens.listUsers.ListUsersScreen
import ru.surf.users.ui.screens.viewUser.ViewUserScreen

/**
 * Routing for [ListUsersScreen], [ViewUserScreen]
 *
 * @author Vitaliy Zarubin
 */
object UsersNavScreen {
    val ListUsersNavScreen = object : NavScreen {
        override val route: String = "ListUsersScreen"
    }
    val ViewUserNavScreen = object : NavScreenWithArgument {
        override val argument0: String = "userId"
        override val routeWithArgument: String = "ViewUserScreen/{$argument0}"
    }
}
