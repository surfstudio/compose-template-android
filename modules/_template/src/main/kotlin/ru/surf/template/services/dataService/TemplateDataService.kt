/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.services.dataService

import ru.surf.template.base.TemplateDatabase
import ru.surf.template.services.dataService.impl.TemplateModelDataService

// @todo {ModuleName}DataService
// @todo {ModuleName}Database
// @todo {ModuleName}Preferences
// @todo {ModelName}DataService
class TemplateDataService(
    override val db: TemplateDatabase
) : TemplateModelDataService
