package ru.surf.other.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.graph.impl.loginScreenGraph

fun NavGraphBuilder.otherNavGraph(
    navActions: OtherNavActions,
) {
    loginScreenGraph(navActions)
}