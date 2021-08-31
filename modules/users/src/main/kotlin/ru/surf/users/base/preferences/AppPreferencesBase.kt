package ru.surf.users.base.preferences

import android.content.SharedPreferences

interface AppPreferencesBase {

    val p: SharedPreferences

    enum class KEYS {
        IS_START_PAGE,
    }

    fun clearAfterLogout() {

    }

    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}