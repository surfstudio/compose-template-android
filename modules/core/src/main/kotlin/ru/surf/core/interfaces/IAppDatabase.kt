package ru.surf.core.interfaces

import androidx.room.RoomDatabase

interface IAppDatabase {
    val db: RoomDatabase
    fun clearCacheAfterLogout()
}