package ru.surf.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.core.data.models.SecurityModel

@Dao
interface SecurityModelDao {
    @Query("SELECT * FROM SecurityModel WHERE id = :userId")
    fun getModel(userId: String): Flow<SecurityModel?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: SecurityModel)

    @Query("DELETE FROM SecurityModel")
    suspend fun clear()
}
