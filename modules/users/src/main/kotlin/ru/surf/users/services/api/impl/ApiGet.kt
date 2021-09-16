package ru.surf.users.services.api.impl

import androidx.annotation.IntRange
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.surf.users.data.responses.UserResponse
import ru.surf.users.utils.ConstantsPaging

interface ApiGet {
    @GET("users")
    suspend fun getListUsers(
        @Query("search")
        search: String?,
        @Query("offset")
        offset: Int = 1,
        @IntRange(from = 1, to = ConstantsPaging.MAX_PAGE_SIZE.toLong())
        @Query("limit")
        limit: Int = ConstantsPaging.PAGE_LIMIT,
    ): Response<List<UserResponse>>
}