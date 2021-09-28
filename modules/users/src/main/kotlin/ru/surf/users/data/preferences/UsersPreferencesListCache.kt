/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

/**
 * Lists service shared preference for module
 *
 * @author Vitaliy Zarubin
 */
interface UsersPreferencesListCache : IAppPreferences {

    /**
     * Store private, primitive data in key-value pairs [SharedPreferences]
     */
    override val p: SharedPreferences

    /**
     * We put the keys in enum
     */
    enum class KEYS {
        LAST_UPDATE_LIST_USERS,
    }

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: UsersPreferencesListCache")
        lastUpdateListUsers = 0L
    }

    /**
     * Saving list update data
     */
    var lastUpdateListUsers: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_USERS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_USERS.name, value).apply()
}
