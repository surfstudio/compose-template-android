/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.drawer

/**
 * Application menu actions
 *
 * @author Vitaliy Zarubin
 */
sealed class AppDrawerActions {
    /**
     * Navigation to user module
     */
    object ToUsers : AppDrawerActions()
    /**
     * Navigation to settings module
     */
    object ToSettings : AppDrawerActions()
}
