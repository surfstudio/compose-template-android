/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

/**
 * Model saved with encryption for access
 *
 * @property token singIn/Up string for authorization
 *
 * @author Vitaliy Zarubin
 */
@Entity
@Immutable
data class SecurityModel(
    @PrimaryKey override val id: String = "last",
    val token: String = "",
) : IModel
