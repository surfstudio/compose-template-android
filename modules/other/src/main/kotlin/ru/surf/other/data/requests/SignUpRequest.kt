/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
