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

import java.util.concurrent.TimeUnit

/**
 * Constants for paging lists
 *
 * @author Vitaliy Zarubin
 */
object ConstantsPaging {

    /**
     * Lists refresh once per hour
     */
    val CACHE_TIMEOUT = TimeUnit.HOURS.toMillis(1)

    /**
     * Max count list items
     */
    const val MAX_PAGE_SIZE = 100

    /**
     * Query page size
     */
    const val PAGE_LIMIT = 5
}
