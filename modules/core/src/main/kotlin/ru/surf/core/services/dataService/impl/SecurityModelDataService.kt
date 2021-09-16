package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.SecurityModel

interface SecurityModelDataService {

    val dbSecurity: CoreSecurityDatabase

    private val dao: SecurityModelDao get() = dbSecurity.securityModelDao()

    suspend fun insertSecurityModel(vararg models: SecurityModel) {
        dao.insertModels(*models)
    }

    suspend fun getSecurityModel(userId: String): Flow<SecurityModel?> {
        return dao.getModel(userId)
    }

    suspend fun clearSecurityModel() {
        dao.clear()
    }
}