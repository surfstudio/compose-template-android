package ru.surf.core.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.core.data.dao.SecurityModelDao
import ru.surf.core.data.models.SecurityModel

@Database(
    entities = [
        SecurityModel::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CoreSecurityDatabase : RoomDatabase() {
    abstract fun securityModelDao(): SecurityModelDao
}