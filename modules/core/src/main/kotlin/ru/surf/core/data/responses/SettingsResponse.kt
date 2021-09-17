package ru.surf.core.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class SettingsResponse(
    val key: String,
    val value: String,
)