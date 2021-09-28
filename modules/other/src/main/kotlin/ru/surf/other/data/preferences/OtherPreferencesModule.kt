/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

/**
 * Common service shared preference for module
 *
 * @author Vitaliy Zarubin
 */
interface OtherPreferencesModule : IAppPreferences {

    /**
     * Store private, primitive data in key-value pairs [SharedPreferences]
     */
    override val p: SharedPreferences

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: OtherPreferencesModule")
    }
}
