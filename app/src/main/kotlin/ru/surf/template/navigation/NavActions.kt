package ru.surf.template.navigation

import androidx.navigation.NavHostController
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.template.navigation.actions.AppNavActions
import ru.surf.users.navigation.actions.UsersNavActions

class NavActions(
    override val controller: NavHostController,
) : AppNavActions, UsersNavActions, OtherNavActions