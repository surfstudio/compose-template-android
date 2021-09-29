/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.mappers

import ru.surf.users.data.models.UserModel
import ru.surf.users.data.responses.UserResponse

/**
 * Extension for response [UserResponse]
 *
 * @author Vitaliy Zarubin
 */
fun UserResponse.toModel(): UserModel {
    return UserModel(
        id = code.toString(),
        name = name ?: "",
    )
}

/**
 * Extension for list response [UserModel]
 *
 * @author Vitaliy Zarubin
 */
fun List<UserResponse>.toModels(): List<UserModel> {
    return map { it.toModel() }
}
