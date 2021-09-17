package ru.surf.template.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
// @todo {ModelName}Response
data class TemplateResponse(
    val code: Int,
    val name: String?,
)