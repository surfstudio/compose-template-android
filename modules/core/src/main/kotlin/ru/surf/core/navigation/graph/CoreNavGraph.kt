/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.core.navigation.actions.CoreNavActions
import ru.surf.core.navigation.graph.impl.statusScreenGraph

fun NavGraphBuilder.mainNavGraph(
    navActions: CoreNavActions,
) {
    statusScreenGraph(navActions)
}
