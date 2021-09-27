/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.requests

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class SignUpValidateRequest(
    val email: String,
)
