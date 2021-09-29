/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences

/**
 * Base service shared preference module
 *
 * @author Vitaliy Zarubin
 */
class SettingsPreferences(override val p: SharedPreferences) : IAppPreferences {

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
    }
}
