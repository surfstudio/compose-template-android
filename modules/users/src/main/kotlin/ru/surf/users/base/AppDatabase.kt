package ru.surf.users.base

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.users.data.dao.DaoUserModel
import ru.surf.users.data.models.UserModel

@Database(
    entities = [
        UserModel::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoUserModel(): DaoUserModel
}