/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.template.navigation.nav.TemplateNav

// @todo {ScreenName}ScreenActions
interface TemplateScreenActions {

    val controller: NavHostController

    fun navigateToList() {
        controller.navigate(TemplateNav.MainNav.ListTemplateScreen.route)
    }
}
