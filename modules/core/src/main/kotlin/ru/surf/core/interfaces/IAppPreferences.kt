/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.interfaces

import android.content.SharedPreferences

/**
 * Interface for services shared preferences
 *
 * @author Vitaliy Zarubin
 */
interface IAppPreferences {
    val p: SharedPreferences
    fun clearCacheAfterLogout()
}
