package ru.surf.other.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class LoginResponse(
    val token: String?,
)