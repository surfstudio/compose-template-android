package ru.surf.core.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

@Entity
@Immutable
data class SettingsModel(
    @PrimaryKey override val id: String,
    val value: String = "",
) : IModel
