/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.mock

import ru.surf.users.data.models.UserModel

/**
 * Mock [UserModel] for compose preview
 *
 * @author Vitaliy Zarubin
 */
fun userModelMock() = UserModel(
    id = "id",
    name = "User Product",
)
