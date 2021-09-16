package ru.surf.core.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

@Entity
@Immutable
data class AppUserModel(
    @PrimaryKey override val id: String,
    val name: String = "",
) : IModel
