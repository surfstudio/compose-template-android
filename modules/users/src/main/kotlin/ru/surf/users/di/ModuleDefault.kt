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
package ru.surf.users.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.data.preferences.CorePreferences
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.dataService.UsersDataService

/**
 * Dagger Module base for module (users)
 *
 * @author Vitaliy Zarubin
 */
@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    /**
     * A database that doesn't need migrations and encryption
     */
    @Provides
    fun provideUsersDatabase(application: Application): UsersDatabase {
        return Room.databaseBuilder(application, UsersDatabase::class.java, "${ModuleDefault::class.qualifiedName}.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Database management service
     */
    @Provides
    fun provideUsersDataService(db: UsersDatabase) = UsersDataService(db)

    /**
     * Shared preferences service
     */
    @Provides
    fun provideUsersPreferences(corePreferences: CorePreferences) = UsersPreferences(corePreferences.p)
}
