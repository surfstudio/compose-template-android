package ru.surf.users.navigation.nav.impl

import com.keygenqt.routing.NavScreen
import com.keygenqt.routing.NavScreenWithArgument

object UsersNavScreen {
    val ListUsersScreen = object : NavScreen {
        override val route: String = "ListUsersScreen"
    }
    val ViewUserScreen = object : NavScreenWithArgument {
        override val argument0: String = "userId"
        override val routeWithArgument: String = "ViewUserScreen/{$argument0}"
    }
}