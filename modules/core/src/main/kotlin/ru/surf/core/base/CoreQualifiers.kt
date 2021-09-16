package ru.surf.core.base

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseQualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseSecurityQualifier