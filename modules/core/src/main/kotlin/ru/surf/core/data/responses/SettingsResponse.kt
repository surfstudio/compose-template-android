/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import ru.surf.core.data.models.SettingsModel

/**
 * Response for [SettingsModel]
 *
 * @property key key from api
 * @property value string data
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class SettingsResponse(
    val key: String,
    val value: String,
)
