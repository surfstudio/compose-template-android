package ru.surf.users.navigation.graph

import androidx.navigation.NavGraphBuilder
import ru.surf.users.navigation.actions.UsersNavActions
import ru.surf.users.navigation.graph.impl.usersScreenGraph

fun NavGraphBuilder.favoriteNavGraph(
    navActions: UsersNavActions,
) {
    usersScreenGraph(navActions)
}