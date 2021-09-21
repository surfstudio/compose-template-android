package ru.surf.template.data.preferences

import android.content.SharedPreferences

// @todo {ModuleName}Preferences
// @todo {ModuleName}Preferences{CustomName}
class TemplatePreferences(override val p: SharedPreferences) :
    TemplatePreferencesListCache {

    override fun clearCacheAfterLogout() {
        super<TemplatePreferencesListCache>.clearCacheAfterLogout()
    }
}