package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppPreferences

interface UsersPreferencesBase : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        IS_START_PAGE,
    }

    override fun clearAfterLogout() {

    }

    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}