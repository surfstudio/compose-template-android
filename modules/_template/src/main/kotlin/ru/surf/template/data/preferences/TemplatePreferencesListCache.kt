package ru.surf.template.data.preferences

import android.content.SharedPreferences
import ru.surf.core.base.CorePreferences
import ru.surf.core.interfaces.IAppPreferences

// @todo {ModuleName}Preferences{CustomName}
interface TemplatePreferencesListCache : IAppPreferences {

    override val p: SharedPreferences

    enum class KEYS {
        LAST_UPDATE_LIST_TEMPLATE,
    }

    override fun clearAfterLogout() {
        lastUpdateListTemplate = 0L
    }

    var lastUpdateListTemplate: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_TEMPLATE.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_TEMPLATE.name, value).apply()

}