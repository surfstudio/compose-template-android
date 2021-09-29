/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.requests

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

/**
 * @Body request sign in user
 *
 * @property username login email user
 * @property password just password
 * @property rememberMe do not dump token
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class SignInRequest(
    val username: String,
    val password: String,
    val rememberMe: Boolean = true,
)
