/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template.drawer

sealed class AppDrawerActions {
    object ToUsers : AppDrawerActions()
    object ToSettings : AppDrawerActions()
}
