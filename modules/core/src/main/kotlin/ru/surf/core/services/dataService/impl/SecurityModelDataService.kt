package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreSecurityDatabase
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.interfaces.IAppDatabase
import timber.log.Timber

interface SecurityModelDataService: IAppDatabase {

    val dbSecurity: CoreSecurityDatabase

    private val dao: SecurityModelDao get() = dbSecurity.securityModelDao()

    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: SecurityModelDataService")
    }

    suspend fun insertSecurityModel(vararg models: SecurityModel) {
        dao.insertModels(*models)
    }

    fun getSecurityModel(): Flow<SecurityModel?> {
        return dao.getModel()
    }

    suspend fun clearSecurityModel() {
        dao.clear()
    }

    fun isLogin(): Boolean {
        return dao.count() != 0
    }
}