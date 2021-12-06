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
package ru.surf.core.services.dataService.impl

import kotlinx.coroutines.flow.Flow
import ru.surf.core.base.CoreDatabase
import ru.surf.core.data.dao.SettingsModelDao
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.interfaces.IAppDatabase
import ru.surfstudio.android.logger.Logger

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
        Logger.d("Clear cache: SettingsModelDataService")
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
