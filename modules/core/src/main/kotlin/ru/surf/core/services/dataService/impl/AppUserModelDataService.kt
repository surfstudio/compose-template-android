package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreDatabase
import ru.surf.core.data.dao.AppUserModelDao
import ru.surf.core.data.models.AppUserModel

interface AppUserModelDataService {

    val db: CoreDatabase

    private val dao: AppUserModelDao get() = db.appUserModelDao()

    suspend fun insertAppUserModel(vararg models: AppUserModel) {
        dao.insertModels(*models)
    }

    suspend fun getAppUserModel(userId: String): Flow<AppUserModel?> {
        return dao.getModel(userId)
    }

    suspend fun clearAppUserModel() {
        dao.clear()
    }
}