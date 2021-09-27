/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.utils

import java.util.concurrent.TimeUnit

object ConstantsPaging {

    // lists refresh once per hour
    val CACHE_TIMEOUT = TimeUnit.HOURS.toMillis(1)

    // const for api query
    const val MAX_PAGE_SIZE = 100
    const val PAGE_LIMIT = 5
}
