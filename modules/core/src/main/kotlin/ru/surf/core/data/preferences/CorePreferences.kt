/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences

/**
 * Base service shared preference module
 *
 * @author Vitaliy Zarubin
 */
class CorePreferences(override val p: SharedPreferences) : IAppPreferences {

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {}
}
