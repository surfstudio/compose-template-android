/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.services.api

import ru.surf.core.services.api.impl.ApiDelete
import ru.surf.template.services.api.impl.*

// @todo {ModuleName}Api
interface TemplateApi : ApiDelete, ApiGet, ApiPatch, ApiPost, ApiPut
