/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences

class UsersPreferences(override val p: SharedPreferences) :
    UsersPreferencesBase,
    UsersPreferencesListCache {

    override fun clearCacheAfterLogout() {
        super<UsersPreferencesBase>.clearCacheAfterLogout()
        super<UsersPreferencesListCache>.clearCacheAfterLogout()
    }
}
