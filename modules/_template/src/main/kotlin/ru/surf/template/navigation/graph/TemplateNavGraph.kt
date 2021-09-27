/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.template.navigation.actions.TemplateNavActions
import ru.surf.template.navigation.graph.impl.templateScreenGraph

// @todo {ModuleName}NavGraph
fun NavGraphBuilder.templateNavGraph(
    navActions: TemplateNavActions,
) {
    // @todo {ScreenName}ScreenGraph
    templateScreenGraph(navActions)
}
