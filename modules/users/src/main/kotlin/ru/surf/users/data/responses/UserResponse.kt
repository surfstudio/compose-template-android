package ru.surf.users.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class UserResponse(
    val code: Int,
    val name: String?,
)