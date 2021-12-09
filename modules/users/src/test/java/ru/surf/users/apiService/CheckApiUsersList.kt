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

@RunWith(MockitoJUnitRunner::class)
class CheckApiUsersList : ApiAbstract(
    path = "api-response/users/list"
) {

    private val api = api<UsersApi>()

    @Test
    fun `check get list user models 200`() {
        runBlockingApi("getListUsers_200.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getListUsers(0)
            // Assert
            assert(response is ResponseResult.Success)
            assertEquals((response as ResponseResult.Success).data.size, 5)
        }
    }

    @Test
    fun `check get list user models 200 empty`() {
        runBlockingApi("getListUsers_200_empty.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getListUsers(0)
            // Assert
            assert(response is ResponseResult.Success)
            assertEquals((response as ResponseResult.Success).data.size, 0)
        }
    }

    @Test
    fun `check get list user models 500`() {
        runBlockingApi("getListUsers_500.json", 500) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getListUsers(0)
            // Assert
            assert(response is ResponseResult.Error)
            assert((response as ResponseResult.Error).exception is HTTPResult.Result500)
        }
    }

    @Test
    fun `check get list user models error json`() {
        runBlockingApi("getListUsers_error_json.json", 200) {
            // Arrange
            val sut = UsersApiService(api)
            // Act
            val response = sut.getListUsers(0)
            // Assert
            assert(response is ResponseResult.Error)
            assert((response as ResponseResult.Error).exception is SerializationException)
        }
    }
}
