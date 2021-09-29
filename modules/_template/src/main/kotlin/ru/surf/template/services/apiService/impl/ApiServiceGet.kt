/**
 * Copyright 2021 Surf
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
