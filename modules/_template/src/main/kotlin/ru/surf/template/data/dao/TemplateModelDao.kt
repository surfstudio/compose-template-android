/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
