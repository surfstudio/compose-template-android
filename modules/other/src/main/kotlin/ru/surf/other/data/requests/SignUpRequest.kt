/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.requests

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

/**
 * @Body request registration user
 *
 * @property email login email user
 * @property password just password
 * @property fname string name user
 * @property lname string surname user
 * @property phoneWork string phone from work
 * @property phoneHome string phone form home
 * @property card string format ####-####-####-####
 * @property cvc string format ###
 * @property bio text about user
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class SignUpRequest(
    val email: String,
    val password: String,
    val fname: String,
    val lname: String,
    val phoneWork: String,
    val phoneHome: String,
    val card: String,
    val cvc: String,
    val bio: String,
)
