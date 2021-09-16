package ru.surf.core.interfaces

import androidx.room.RoomDatabase
import androidx.room.withTransaction

interface IAppDatabase<T : Any> {

    val db: RoomDatabase
    val preferences: IAppPreferences

    @Suppress("UNCHECKED_CAST")
    suspend fun withTransaction(body: suspend T.() -> Unit) {
        db.withTransaction {
            body.invoke(this as T)
        }
    }
}