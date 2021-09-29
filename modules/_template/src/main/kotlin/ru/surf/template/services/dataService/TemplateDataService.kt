/**
 * Copyright 2021 Surf
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
