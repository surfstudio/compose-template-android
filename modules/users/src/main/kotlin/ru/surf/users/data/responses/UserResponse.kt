/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import ru.surf.users.data.models.UserModel

/**
 * Response for [UserModel]
 *
 * @property code identifier user
 * @property name user name fname + lname
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class UserResponse(
    val code: Int,
    val name: String?,
)
