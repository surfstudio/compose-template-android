package ru.surf.template.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import ru.surf.users.navigation.nav.UsersNav

enum class HomeTab(
    val route: String,
    val icon: ImageVector,
) {

    USERS(UsersNav.MainNav.ListUsersScreen.route, Icons.Filled.List);

    companion object {
        fun String.findByRoute(): HomeTab? {
            return when (this) {
                USERS.route -> USERS
                else -> null
            }
        }
    }
}