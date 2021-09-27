/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseQualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseSecurityQualifier
