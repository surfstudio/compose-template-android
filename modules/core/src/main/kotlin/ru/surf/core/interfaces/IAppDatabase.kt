/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.interfaces

import androidx.room.RoomDatabase

interface IAppDatabase {
    val db: RoomDatabase
    fun clearCacheAfterLogout()
}
