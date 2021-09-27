/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation

import androidx.navigation.NavHostController
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.settings.navigation.actions.SettingsNavActions
import ru.surf.users.navigation.actions.UsersNavActions

/**
 * Base actions for modules
 *
 * @author Vitaliy Zarubin
 */
class NavActions(
    override val controller: NavHostController,
) : CoreNavActions,
    UsersNavActions,
    OtherNavActions,
    SettingsNavActions
