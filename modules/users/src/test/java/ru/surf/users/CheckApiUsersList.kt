package ru.surf.users

import com.keygenqt.response.ResponseResult
import com.keygenqt.response.tests.ApiAbstract
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import ru.surf.users.services.api.UsersApi
import ru.surf.users.services.apiService.UsersApiService

@RunWith(MockitoJUnitRunner::class)
class CheckApiUsersList : ApiAbstract() {

    private val api = api<UsersApi>()

    @Test
    fun `check get list user models`() {
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
}