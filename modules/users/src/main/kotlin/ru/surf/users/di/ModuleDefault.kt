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
