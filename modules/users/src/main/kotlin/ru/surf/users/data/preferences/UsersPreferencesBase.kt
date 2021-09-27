/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

interface UsersPreferencesBase : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        IS_START_PAGE,
    }

    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: UsersPreferencesBase")
    }

    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}
