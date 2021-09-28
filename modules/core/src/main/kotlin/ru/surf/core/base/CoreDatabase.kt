/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.core.data.dao.SettingsModelDao
import ru.surf.core.data.models.SettingsModel

/**
 * Database configuration [RoomDatabase]
 *
 * @author Vitaliy Zarubin
 */
@Database(
    entities = [
        SettingsModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun settingsModelDao(): SettingsModelDao
}
