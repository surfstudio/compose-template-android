package ru.surf.other.data.preferences

import android.content.SharedPreferences
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppPreferences

interface OtherPreferencesModule : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        IS_ONBOARDING,
    }

    override fun clearAfterLogout() {

    }
}