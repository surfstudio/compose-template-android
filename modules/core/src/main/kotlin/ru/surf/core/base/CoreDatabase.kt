package ru.surf.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.core.data.dao.AppUserModelDao
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.AppUserModel

@Database(
    entities = [
        AppUserModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun appUserModelDao(): AppUserModelDao
}