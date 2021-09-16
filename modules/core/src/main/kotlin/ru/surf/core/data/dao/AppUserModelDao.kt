package ru.surf.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.core.data.models.AppUserModel

@Dao
interface AppUserModelDao {
    @Query("SELECT * FROM AppUserModel WHERE id = :userId")
    fun getModel(userId: String): Flow<AppUserModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: AppUserModel)

    @Query("DELETE FROM AppUserModel")
    suspend fun clear()
}
