package ru.surf.template.data.mappers

import ru.surf.template.data.models.TemplateModel
import ru.surf.template.data.responses.TemplateResponse

// @todo {ModelName}Response
// @todo {ModelName}Model
fun TemplateResponse.toModel(): TemplateModel {
    return TemplateModel(
        id = code.toString(),
        name = name ?: "",
    )
}

// @todo {ModelName}Response
// @todo {ModelName}Model
fun List<TemplateResponse>.toModels(): List<TemplateModel> {
    return map { it.toModel() }
}