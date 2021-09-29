/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

/**
 * Response after validate email
 *
 * @property status is valid
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class SignUpValidateResponse(
    val status: Boolean,
)
