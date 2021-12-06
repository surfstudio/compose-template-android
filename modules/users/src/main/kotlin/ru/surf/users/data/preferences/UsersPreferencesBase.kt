/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.users.data.preferences

import android.content.SharedPreferences
import ru.surf.core.interfaces.IAppPreferences
import ru.surfstudio.android.logger.Logger

/**
 * Common service shared preference for module
 *
 * @author Vitaliy Zarubin
 */
interface UsersPreferencesBase : IAppPreferences {

    /**
     * Store private, primitive data in key-value pairs [SharedPreferences]
     */
    override val p: SharedPreferences

    /**
     * We put the keys in enum
     */
    enum class KEYS {
        IS_START_PAGE,
    }

    /**
     * Performed when the user logs out
     */
    override fun clearCacheAfterLogout() {
        Logger.d("Clear cache: UsersPreferencesBase")
    }

    /**
     * An example of a possible variable
     */
    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}
