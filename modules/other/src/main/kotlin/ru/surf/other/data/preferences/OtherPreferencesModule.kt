package ru.surf.other.data.preferences

import android.content.SharedPreferences
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppPreferences
import timber.log.Timber

interface OtherPreferencesModule : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        IS_ONBOARDING,
    }

    override fun clearAfterLogout() {
        Timber.e("Clear cache: OtherPreferencesModule")
    }
}