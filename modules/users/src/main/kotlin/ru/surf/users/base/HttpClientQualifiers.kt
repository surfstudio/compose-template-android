package ru.surf.users.base

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class RestHttpClient

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class WebSocketClient