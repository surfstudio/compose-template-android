/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.users.data.models.UserModel

@Dao
interface UserModelDao {
    @Query("SELECT * FROM UserModel ORDER BY CAST(id AS INT)")
    fun pagingSource(): PagingSource<Int, UserModel>

    @Query("SELECT * FROM UserModel WHERE id = :id")
    fun getModel(id: String): Flow<UserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: UserModel)

    @Query("DELETE FROM UserModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM UserModel")
    suspend fun count(): Int
}
