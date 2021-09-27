/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

interface OtherPreferencesModule : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        IS_ONBOARDING,
    }

    override fun clearCacheAfterLogout() {
        Timber.e("Clear cache: OtherPreferencesModule")
    }
}
