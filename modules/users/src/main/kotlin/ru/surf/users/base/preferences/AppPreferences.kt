package ru.surf.users.base.preferences

import android.content.SharedPreferences

class AppPreferences(override val p: SharedPreferences) :
    AppPreferencesBase,
    AppPreferencesListCache {

    override fun clearAfterLogout() {
        super<AppPreferencesBase>.clearAfterLogout()
        super<AppPreferencesListCache>.clearAfterLogout()
    }
}