/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.surf.core.base.CorePreferences
import ru.surf.users.base.UsersDatabase
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.services.dataService.UsersDataService

@Module
@InstallIn(SingletonComponent::class)
object ModuleDefault {

    @Provides
    fun provideUsersDatabase(application: Application): UsersDatabase {
        return Room.databaseBuilder(application, UsersDatabase::class.java, "${ModuleDefault::class.qualifiedName}.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUsersDataService(db: UsersDatabase) = UsersDataService(db)

    @Provides
    fun provideUsersPreferences(corePreferences: CorePreferences) = UsersPreferences(corePreferences.p)
}
