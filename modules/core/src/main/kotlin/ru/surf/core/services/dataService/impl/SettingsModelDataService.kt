/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreDatabase
import ru.surf.core.data.dao.SettingsModelDao
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.interfaces.IAppDatabase
import timber.log.Timber

/**
 * Service part for work with model [SettingsModel]
 *
 * @author Vitaliy Zarubin
 */
interface SettingsModelDataService : IAppDatabase {

    /**
     * Base room db
     */
    override val db: CoreDatabase

    /**
     * Doa model [SettingsModel]
     */
    private val dao: SettingsModelDao get() = db.settingsModelDao()

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: SettingsModelDataService")
    }

    /**
     * Fun for insert models
     */
    suspend fun insertSettingsModel(vararg models: SettingsModel) {
        dao.insertModels(*models)
    }

    /**
     * Get [Flow] model
     */
    suspend fun getSettingsModel(): Flow<List<SettingsModel>> {
        return dao.getModels()
    }

    /**
     * Remove all models
     */
    suspend fun clearSettingsModel() {
        dao.clear()
    }
}
