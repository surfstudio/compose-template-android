/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

/**
 * User model base for module
 *
 * @property id identifier user
 * @property name user name fname + lname
 *
 * @author Vitaliy Zarubin
 */
@Entity
@Immutable
data class UserModel(
    @PrimaryKey override val id: String,
    val name: String,
) : IModel
