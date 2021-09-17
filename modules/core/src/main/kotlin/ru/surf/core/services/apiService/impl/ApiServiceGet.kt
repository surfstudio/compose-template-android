package ru.surf.core.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.surf.core.BuildConfig
import ru.surf.core.data.mappers.toModels
import ru.surf.core.data.models.SettingsModel
import ru.surf.core.services.api.CoreApi
import ru.surf.core.utils.ConstantsApp

interface ApiServiceGet {

    val api: CoreApi

    suspend fun getListSettings(): ResponseResult<List<SettingsModel>> {
        return withContext(Dispatchers.IO) {
            if (BuildConfig.DEBUG) delay(ConstantsApp.DEBUG_DELAY) // Simulate slow internet
            LocalTryExecuteWithResponse.executeWithResponse {
                api.getListSettings()
                    .responseCheck()
                    .body()
                    ?.toModels()
                    ?: emptyList()
            }
        }
    }
}