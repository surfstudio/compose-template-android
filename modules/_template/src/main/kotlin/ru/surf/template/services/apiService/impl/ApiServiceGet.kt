/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.services.apiService.impl

import com.keygenqt.response.LocalTryExecuteWithResponse.executeWithResponse
import com.keygenqt.response.ResponseResult
import com.keygenqt.response.responseCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.surf.template.data.mappers.toModels
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.services.api.TemplateApi

// @todo getList{CustomName}
// @todo getView{CustomName}
// @todo getCreate{CustomName}
// @todo getDelete{CustomName}
// @todo getUpdate{CustomName}
/**
 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
 *
 * @author Vitaliy Zarubin
 */
interface ApiServiceGet {

    val api: TemplateApi

    suspend fun getListTemplate(offset: Int, search: String? = null): ResponseResult<List<TemplateModel>> {
        return withContext(Dispatchers.IO) {
            executeWithResponse {
                api.getListTemplate(offset = offset, search = search)
                    .responseCheck()
                    .body()
                    ?.toModels()
                    ?: emptyList()
            }
        }
    }
}
