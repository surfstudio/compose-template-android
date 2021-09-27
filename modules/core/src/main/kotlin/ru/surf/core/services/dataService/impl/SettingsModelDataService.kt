/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreDatabase
import ru.surf.core.data.dao.SettingsModelDao
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.interfaces.IAppDatabase
import timber.log.Timber

interface SettingsModelDataService : IAppDatabase {

    override val db: CoreDatabase

    private val dao: SettingsModelDao get() = db.settingsModelDao()

    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: SettingsModelDataService")
    }

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
