/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.preferences

import android.content.SharedPreferences

class OtherPreferences(override val p: SharedPreferences) :
    OtherPreferencesModule {

    override fun clearCacheAfterLogout() {
        super<OtherPreferencesModule>.clearCacheAfterLogout()
    }
}
