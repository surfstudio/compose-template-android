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
package ru.surf.users.apiService

import kotlinx.serialization.SerializationException
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import ru.surf.core.tests.ApiAbstract
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService
import ru.surfstudio.compose.response.HTTPResult
import ru.surfstudio.compose.response.ResponseResult
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class CheckApiUsersView : ApiAbstract(
    path = "api-response/users/view"
) {

    private val api = api<UsersApi>()

    @Test
    fun `check get view user model 200`() {
        runBlockingApi("getViewUser_200.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getViewUser(UUID.randomUUID().toString())
            // Assert
            assert(response is ResponseResult.Success)
            assertEquals((response as ResponseResult.Success).data.name, "Olivia")
        }
    }

    @Test
    fun `check get view user model 200 is empty object`() {
        runBlockingApi("getViewUser_200_empty.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getViewUser(UUID.randomUUID().toString())
            // Assert
            assert(response is ResponseResult.Error)
            assert((response as ResponseResult.Error).exception is SerializationException)
        }
    }

    @Test
    fun `check get view user model 500`() {
        runBlockingApi("getViewUser_500.json", 500) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getViewUser(UUID.randomUUID().toString())
            // Assert
            assert(response is ResponseResult.Error)
            assert((response as ResponseResult.Error).exception is HTTPResult.Result500)
        }
    }

    @Test
    fun `check get view user model error json`() {
        runBlockingApi("getViewUser_error_json.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getViewUser(UUID.randomUUID().toString())
            // Assert
            assert(response is ResponseResult.Error)
            assert((response as ResponseResult.Error).exception is SerializationException)
        }
    }
}
