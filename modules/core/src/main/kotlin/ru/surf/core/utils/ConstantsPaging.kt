/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
