/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import javax.inject.Qualifier

/**
 * For database that doesn't need migrations and encryption
 *
 * @author Vitaliy Zarubin
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseQualifier


/**
 * For database with encryption and migrations
 *
 * @author Vitaliy Zarubin
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CoreDatabaseSecurityQualifier
