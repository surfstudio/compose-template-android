package ru.surf.other.data.preferences

import android.content.SharedPreferences

class OtherPreferences(override val p: SharedPreferences) :
    OtherPreferencesModule {

    override fun clearAfterLogout() {
        super<OtherPreferencesModule>.clearAfterLogout()
    }
}