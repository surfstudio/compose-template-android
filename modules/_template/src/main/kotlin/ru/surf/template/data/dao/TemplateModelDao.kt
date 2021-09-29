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
package ru.surf.template.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.template.data.models.TemplateModel

@Dao
// @todo {ModelName}ModelDao
// @todo {ModelName}Model
interface TemplateModelDao {
    @Query("SELECT * FROM TemplateModel")
    fun pagingSource(): PagingSource<Int, TemplateModel>

    @Query("SELECT * FROM TemplateModel WHERE id = :id")
    fun getModel(id: Int): Flow<TemplateModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: TemplateModel)

    @Query("DELETE FROM TemplateModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM TemplateModel")
    suspend fun count(): Int
}
