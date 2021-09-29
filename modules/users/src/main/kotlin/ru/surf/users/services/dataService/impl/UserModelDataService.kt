/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.services.dataService.impl

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.dao.UserModelDao
import ru.surf.users.data.models.UserModel
import timber.log.Timber

/**
 * Service part for work with model [UserModel]
 *
 * @author Vitaliy Zarubin
 */
interface UserModelDataService : IAppDatabase {

    /**
     * Base room db
     */
    override val db: UsersDatabase

    /**
     * Doa model [UserModel]
     */
    private val dao: UserModelDao get() = db.daoUserModel()

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: UserModelDataService")
    }

    /**
     * Get [Flow] model
     */
    fun getUserModel(userId: String): Flow<UserModel> {
        return dao.getModel(userId)
    }

    /**
     * Get [PagingSource] for paging list
     */
    fun pagingListUserModel(): PagingSource<Int, UserModel> {
        return dao.pagingSource()
    }

    /**
     * Fun for insert models
     */
    suspend fun insertUserModel(vararg models: UserModel) {
        dao.insertModels(*models)
    }

    /**
     * Remove all models
     */
    suspend fun clearUserModel() {
        dao.clear()
    }

    /**
     * Get count models
     */
    suspend fun countUserModel(): Int {
        return dao.count()
    }
}
