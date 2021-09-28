/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.users.data.dao.UserModelDao
import ru.surf.users.data.models.UserModel

/**
 * Database configuration [RoomDatabase]
 *
 * @author Vitaliy Zarubin
 */
@Database(
    entities = [
        UserModel::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun daoUserModel(): UserModelDao
}
