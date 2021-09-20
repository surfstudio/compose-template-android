package ru.surf.template.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.template.navigation.actions.AppNavActions
import ru.surf.template.navigation.graph.impl.statusScreenGraph

fun NavGraphBuilder.mainNavGraph(
    navActions: AppNavActions,
) {
    statusScreenGraph(navActions)
}