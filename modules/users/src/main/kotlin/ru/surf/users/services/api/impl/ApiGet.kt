package ru.surf.users.services.api.impl

import androidx.annotation.IntRange
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.surf.core.utils.ConstantsPaging
import ru.surf.users.data.responses.UserResponse

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

    @GET("users/{id}")
    suspend fun updateUser(
        @Path("id") id: String?,
    ): Response<UserResponse>
}