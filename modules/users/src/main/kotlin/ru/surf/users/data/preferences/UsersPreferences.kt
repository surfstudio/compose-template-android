/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences

/**
 * Base service shared preference module
 *
 * @author Vitaliy Zarubin
 */
class UsersPreferences(override val p: SharedPreferences) :
    UsersPreferencesBase,
    UsersPreferencesListCache {

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        super<UsersPreferencesBase>.clearCacheAfterLogout()
        super<UsersPreferencesListCache>.clearCacheAfterLogout()
    }
}
