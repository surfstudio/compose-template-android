package ru.surf.template.data.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.surf.core.interfaces.IModel

@Entity
@Immutable
// @todo {ModelName}Model
data class TemplateModel(
    @PrimaryKey override val id: String,
    val name: String,
) : IModel
