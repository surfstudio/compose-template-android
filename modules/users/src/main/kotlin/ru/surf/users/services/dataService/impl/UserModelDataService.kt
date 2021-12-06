/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.users.services.dataService.impl

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import ru.surf.core.interfaces.IAppDatabase
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.dao.UserModelDao
import ru.surf.users.data.models.UserModel
import ru.surfstudio.android.logger.Logger

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
        Logger.d("Clear cache: UserModelDataService")
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
