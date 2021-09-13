package ru.surf.users.base

import androidx.room.withTransaction

interface BaseDataService<T : Any> {

    val db: AppDatabase
    val preferences: AppPreferences

    @Suppress("UNCHECKED_CAST")
    suspend fun withTransaction(body: suspend T.() -> Unit) {
        db.withTransaction {
            body.invoke(this as T)
        }
    }
}