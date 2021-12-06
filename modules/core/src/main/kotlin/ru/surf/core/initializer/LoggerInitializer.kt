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
@file:Suppress("unused")

package ru.surf.core.initializer

import android.content.Context
import androidx.startup.Initializer
import ru.surf.core.logger.RemoteLogger
import ru.surf.core.logger.strategies.local.TimberLoggingStrategy
import ru.surf.core.logger.strategies.remote.FirebaseCrashlyticsRemoteLoggingStrategy
import ru.surf.core.logger.strategies.remote.RemoteLoggerLoggingStrategy
import ru.surfstudio.android.logger.Logger

/**
 * Initialization [Logger]
 *
 * @author Margarita Volodina
 */
class LoggerInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Logger.addLoggingStrategy(TimberLoggingStrategy())
        Logger.addLoggingStrategy(RemoteLoggerLoggingStrategy())
        RemoteLogger.addRemoteLoggingStrategy(FirebaseCrashlyticsRemoteLoggingStrategy())
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
