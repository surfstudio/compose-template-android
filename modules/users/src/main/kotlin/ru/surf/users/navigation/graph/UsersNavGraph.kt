/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.navigation.graph

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavGraphBuilder
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.graph.impl.usersScreenGraph

/**
 * Base block with graphs for module
 *
 * @author Vitaliy Zarubin
 */
fun NavGraphBuilder.usersNavGraph(
    scaffoldState: ScaffoldState,
    navActions: UsersNavActions,
) {
    usersScreenGraph(scaffoldState, navActions)
}
