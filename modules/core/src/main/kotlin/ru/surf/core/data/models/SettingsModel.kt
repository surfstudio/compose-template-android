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
 * Common settings for app
 *
 * @property id key from api
 * @property value string data
 *
 * @author Vitaliy Zarubin
 */
@Entity
@Immutable
data class SettingsModel(
    @PrimaryKey override val id: String,
    val value: String = "",
) : IModel
