package ru.surf.core.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.core.navigation.graph.impl.statusScreenGraph

fun NavGraphBuilder.mainNavGraph(
    navActions: CoreNavActions,
) {
    statusScreenGraph(navActions)
}