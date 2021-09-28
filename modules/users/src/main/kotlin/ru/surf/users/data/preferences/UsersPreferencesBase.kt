/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

/**
 * Common service shared preference for module
 *
 * @author Vitaliy Zarubin
 */
interface UsersPreferencesBase : IAppPreferences {

    /**
     * Store private, primitive data in key-value pairs [SharedPreferences]
     */
    override val p: SharedPreferences

    /**
     * We put the keys in enum
     */
    enum class KEYS {
        IS_START_PAGE,
    }

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: UsersPreferencesBase")
    }

    /**
     * An example of a possible variable
     */
    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}
