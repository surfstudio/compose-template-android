package ru.surf.users.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.users.data.models.UserModel

@Dao
interface DaoUserModel {
    @Query("SELECT * FROM UserModel")
    fun pagingSource(): PagingSource<Int, UserModel>

    @Query("SELECT * FROM UserModel WHERE id = :id")
    fun getModel(id: Int): Flow<UserModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: UserModel)

    @Query("DELETE FROM UserModel")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM UserModel")
    suspend fun count(): Int
}
