package ru.surf.core.interfaces

import android.content.SharedPreferences

interface IAppPreferences {
    val p: SharedPreferences
    fun clearCacheAfterLogout()
}