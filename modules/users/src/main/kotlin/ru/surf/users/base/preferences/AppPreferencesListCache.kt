package ru.surf.users.base.preferences

import android.content.SharedPreferences

interface AppPreferencesListCache {

    val p: SharedPreferences

    enum class KEYS {
        LAST_UPDATE_LIST_USERS,
    }

    fun clearAfterLogout() {
        lastUpdateListUsers = 0L
    }

    var lastUpdateListUsers: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_USERS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_USERS.name, value).apply()

}