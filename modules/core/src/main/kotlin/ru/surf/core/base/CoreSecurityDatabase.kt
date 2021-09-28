/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.SecurityModel
import ru.surf.core.data.models.SettingsModel

/**
 * Database configuration [RoomDatabase]
 *
 * @author Vitaliy Zarubin
 */
@Database(
    entities = [
        SecurityModel::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CoreSecurityDatabase : RoomDatabase() {
    /**
     * Dao for model [SecurityModel]
     */
    abstract fun securityModelDao(): SecurityModelDao
}
