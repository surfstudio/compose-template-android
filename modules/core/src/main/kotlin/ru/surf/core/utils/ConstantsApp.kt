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
package ru.surf.core.utils

import ru.surf.core.BuildConfig

/**
 * Base Constants for App
 *
 * @author Vitaliy Zarubin
 */
object ConstantsApp {

    /**
     * Api url
     */
    const val API_URL = "https://r2.mocker.surfstudio.ru/template/"

    /**
     * For simulate slow internet
     */
    const val DEBUG_DELAY = 1000L

    /**
     * For debug credential login
     */
    val DEBUG_CREDENTIAL_LOGIN get() = if (BuildConfig.DEBUG) "zarubin@surfstudio.ru" else ""

    /**
     * For debug credential password
     */
    val DEBUG_CREDENTIAL_PASSW get() = if (BuildConfig.DEBUG) "123456" else ""
}
