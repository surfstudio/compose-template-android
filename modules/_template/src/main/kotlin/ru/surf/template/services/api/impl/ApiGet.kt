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
package ru.surf.template.services.api.impl

import androidx.annotation.IntRange
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.surf.core.utils.ConstantsPaging
import ru.surf.template.data.responses.TemplateResponse

// @todo getList{CustomName}
// @todo getView{CustomName}
// @todo getCreate{CustomName}
// @todo getDelete{CustomName}
// @todo getUpdate{CustomName}
interface ApiGet {
    @GET("Templates")
    suspend fun getListTemplate(
        @Query("search")
        search: String?,
        @Query("offset")
        offset: Int = 1,
        @IntRange(from = 1, to = ConstantsPaging.MAX_PAGE_SIZE.toLong())
        @Query("limit")
        limit: Int = ConstantsPaging.PAGE_LIMIT,
    ): Response<List<TemplateResponse>>
}
