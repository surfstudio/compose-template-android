package ru.surf.users.navigation.graph

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavGraphBuilder
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.graph.impl.usersScreenGraph

fun NavGraphBuilder.usersNavGraph(
    scaffoldState: ScaffoldState,
    navActions: UsersNavActions,
) {
    usersScreenGraph(scaffoldState, navActions)
}