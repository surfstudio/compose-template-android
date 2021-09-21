package ru.surf.template.navigation

import androidx.navigation.NavHostController
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.users.navigation.actions.UsersNavActions

class NavActions(
    override val controller: NavHostController,
) : CoreNavActions,
    UsersNavActions,
    OtherNavActions