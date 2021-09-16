package ru.surf.core.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

@Entity
@Immutable
data class SecurityModel(
    @PrimaryKey override val id: String,
    val token: String = "",
    val isLogin: Boolean = false,
) : IModel
