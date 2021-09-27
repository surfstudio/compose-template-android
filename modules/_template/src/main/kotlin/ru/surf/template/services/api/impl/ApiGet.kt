/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
