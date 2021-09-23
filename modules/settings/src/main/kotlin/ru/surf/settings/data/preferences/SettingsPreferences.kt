package ru.surf.settings.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences

class SettingsPreferences(override val p: SharedPreferences): IAppPreferences {
    override fun clearCacheAfterLogout() {

    }
}