package ru.surf.core.utils

import ru.surf.core.BuildConfig

object ConstantsApp {
    const val API_URL = "https://r2.mocker.surfstudio.ru/template/"
    const val REFRESH_DELAY = 60000L
    const val DEBUG_DELAY = 1000L
    val DEBUG_CREDENTIAL_LOGIN get() = if (BuildConfig.DEBUG) "zarubin@surfstudio.ru" else ""
    val DEBUG_CREDENTIAL_PASSW get() = if (BuildConfig.DEBUG) "123456" else ""
}