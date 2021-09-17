package ru.surf.users.data.preferences

import android.content.SharedPreferences

class UsersPreferences(override val p: SharedPreferences) :
    UsersPreferencesBase,
    UsersPreferencesListCache {

    override fun clearAfterLogout() {
        super<UsersPreferencesBase>.clearAfterLogout()
        super<UsersPreferencesListCache>.clearAfterLogout()
    }
}