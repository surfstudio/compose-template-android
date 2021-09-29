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
package ru.surf.template.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.template.data.dao.TemplateModelDao
import ru.surf.template.data.models.TemplateModel

@Database(
    entities = [
        // @todo {ModelName}Model
        TemplateModel::class,
    ],
    version = 1,
    exportSchema = false
)
// @todo {ModuleName}Database
abstract class TemplateDatabase : RoomDatabase() {
    // @todo {ModelName}ModelDao
    abstract fun templateModelDao(): TemplateModelDao
}
