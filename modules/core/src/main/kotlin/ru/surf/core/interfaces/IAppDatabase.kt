/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.interfaces

import androidx.room.RoomDatabase

/**
 * Interface for services db root
 *
 * @author Vitaliy Zarubin
 */
interface IAppDatabase {
    val db: RoomDatabase
    fun clearCacheAfterLogout()
}
