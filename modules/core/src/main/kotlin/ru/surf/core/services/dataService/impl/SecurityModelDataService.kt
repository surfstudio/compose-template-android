/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.interfaces.IAppDatabase
import timber.log.Timber

/**
 * Service part for work with model [SecurityModel]
 *
 * @author Vitaliy Zarubin
 */
interface SecurityModelDataService : IAppDatabase {

    /**
     * Base room db
     */
    val dbSecurity: CoreSecurityDatabase

    /**
     * Doa model [SecurityModel]
     */
    private val dao: SecurityModelDao get() = dbSecurity.securityModelDao()

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: SecurityModelDataService")
    }

    /**
     * Fun for insert models
     */
    suspend fun insertSecurityModel(vararg models: SecurityModel) {
        dao.insertModels(*models)
    }

    /**
     * Get [Flow] model
     */
    fun getSecurityModel(): Flow<SecurityModel?> {
        return dao.getModel()
    }

    /**
     * Remove all models
     */
    suspend fun clearSecurityModel() {
        dao.clear()
    }

    /**
     * Check user is login
     */
    fun isLogin(): Boolean {
        return dao.count() != 0
    }
}
