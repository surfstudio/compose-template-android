package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreDatabase
import ru.surf.core.data.dao.SettingsModelDao
import ru.surf.core.data.models.SettingsModel

interface SettingsModelDataService {

    val db: CoreDatabase

    private val dao: SettingsModelDao get() = db.settingsModelDao()

    suspend fun insertSettingsModel(vararg models: SettingsModel) {
        dao.insertModels(*models)
    }

    suspend fun getSettingsModel(): Flow<List<SettingsModel>> {
        return dao.getModels()
    }

    suspend fun clearSettingsModel() {
        dao.clear()
    }
}