package com.pinxter.clowder.dataService

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.dataService.UsersDataService
import java.util.*

@RunWith(AndroidJUnit4::class)
class CheckDbUsers {

    private val db: UsersDatabase by lazy {
        Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UsersDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun check_clear_db() {
        runBlocking {
            // Arrange
            val sut = UsersDataService(db)
            // Act
            sut.clearUserModel()
            // Assert
            assert(sut.countUserModel() == 0)
        }
    }

    @Test
    fun check_add_db() {
        runBlocking {
            // Arrange
            val sut = UsersDataService(db).apply {
                clearUserModel()
            }
            // Act
            sut.insertUserModel(
                UserModel(UUID.randomUUID().toString(), "First"),
                UserModel(UUID.randomUUID().toString(), "Second")
            )
            // Assert
            assert(sut.countUserModel() == 2)
        }
    }
}