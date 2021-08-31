package ru.surf.users.data.responses

import androidx.compose.runtime.Immutable

@Immutable
data class UserResponse(
    val code: String?,
    val name: String?,
)