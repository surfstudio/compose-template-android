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
package ru.surf.users.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

/**
 * User model base for module
 *
 * @property id identifier user
 * @property name user name fname + lname
 *
 * @author Vitaliy Zarubin
 */
@Entity
@Immutable
data class UserModel(
    @PrimaryKey override val id: String,
    val name: String,
) : IModel
