/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences

class CorePreferences(override val p: SharedPreferences) : IAppPreferences {
    override fun clearCacheAfterLogout() {}
}
