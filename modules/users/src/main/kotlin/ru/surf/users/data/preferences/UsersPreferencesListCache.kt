package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

interface UsersPreferencesListCache : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        LAST_UPDATE_LIST_USERS,
    }

    override fun clearAfterLogout() {
        Timber.e("Clear cache: UsersPreferencesListCache")
        lastUpdateListUsers = 0L
    }

    var lastUpdateListUsers: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_USERS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_USERS.name, value).apply()

}