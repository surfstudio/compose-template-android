package ru.surf.users.base

import android.content.SharedPreferences
import ru.surf.users.data.preferences.AppPreferencesBase
import ru.surf.users.data.preferences.AppPreferencesListCache

class AppPreferences(override val p: SharedPreferences) :
    AppPreferencesBase,
    AppPreferencesListCache {

    override fun clearAfterLogout() {
        super<AppPreferencesBase>.clearAfterLogout()
        super<AppPreferencesListCache>.clearAfterLogout()
    }
}