package ru.surf.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.surf.core.data.models.SettingsModel

@Dao
interface SettingsModelDao {
    @Query("SELECT * FROM SettingsModel")
    fun getModels(): Flow<List<SettingsModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(vararg models: SettingsModel)

    @Query("DELETE FROM SettingsModel")
    suspend fun clear()
}
