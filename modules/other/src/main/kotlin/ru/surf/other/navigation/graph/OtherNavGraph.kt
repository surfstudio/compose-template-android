/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.other.navigation.actions.OtherNavActions
import ru.surf.other.navigation.graph.impl.signInScreenGraph
import ru.surf.other.navigation.graph.impl.signUpScreenGraph
import ru.surf.other.navigation.graph.impl.welcomeScreenGraph

/**
 * Base block with graphs for module
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.otherNavGraph(
    navActions: OtherNavActions,
) {
    signInScreenGraph(navActions)
    signUpScreenGraph(navActions)
    welcomeScreenGraph(navActions)
}
