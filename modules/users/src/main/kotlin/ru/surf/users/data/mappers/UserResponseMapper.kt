package ru.surf.users.data.mappers

import ru.surf.users.data.models.UserModel
import ru.surf.users.data.responses.UserResponse

fun UserResponse.toModel(): UserModel {
    return UserModel(
        id = code ?: "",
        name = name ?: "",
    )
}

fun List<UserResponse>.toModels(): List<UserModel> {
    return map { it.toModel() }
}