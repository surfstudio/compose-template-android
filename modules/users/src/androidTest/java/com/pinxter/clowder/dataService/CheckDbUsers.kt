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
package com.pinxter.clowder.dataService

import androidx.paging.PagingSource
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.models.UserModel
import ru.surf.users.services.dataService.UsersDataService

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
            sut.insertUserModel(UserModel("1", "First"), UserModel("2", "Second"))
            // Assert
            assert(sut.countUserModel() == 2)
        }
    }

    @Test
    fun check_get_user() {
        runBlocking {
            // Arrange
            val sut = UsersDataService(db).apply {
                clearUserModel()
                insertUserModel(UserModel("1", "First"), UserModel("2", "Second"))
            }
            // Act
            val user = sut.getUserModel("1")
            // Assert
            launch {
                user.collect {
                    assert(it.name == "First")
                    this.cancel()
                }
            }
        }
    }

    @Test
    fun check_get_paging_source() {
        runBlocking {
            // Arrange
            val data = listOf(UserModel("1", "First"), UserModel("2", "Second"))
            val sut = UsersDataService(db).apply {
                clearUserModel()
                insertUserModel(*data.toTypedArray())
            }
            // Act
            val list = sut.pagingListUserModel()
            // Assert
            assertEquals(
                PagingSource.LoadResult.Page(
                    data = data,
                    prevKey = null,
                    nextKey = null,
                    itemsBefore = 0,
                    itemsAfter = 0,
                ),
                list.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 2,
                        placeholdersEnabled = false
                    )
                )
            )
        }
    }
}
