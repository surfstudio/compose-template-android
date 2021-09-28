/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
