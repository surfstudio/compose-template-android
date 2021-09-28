/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.preferences

import android.content.SharedPreferences

/**
 * Base service shared preference module
 *
 * @author Vitaliy Zarubin
 */
class OtherPreferences(override val p: SharedPreferences) :
    OtherPreferencesModule {

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        super<OtherPreferencesModule>.clearCacheAfterLogout()
    }
}
