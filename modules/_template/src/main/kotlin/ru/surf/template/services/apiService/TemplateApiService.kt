package ru.surf.template.services.apiService

import ru.surf.template.services.api.TemplateApi
import ru.surf.template.services.apiService.impl.*

// @todo {ModuleName}Api
// @todo {ModuleName}ApiService
class TemplateApiService(
    override val api: TemplateApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut