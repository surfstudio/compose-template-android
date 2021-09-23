package ru.surf.template.drawer

sealed class AppDrawerActions {
    object ToUsers : AppDrawerActions()
    object ToSettings : AppDrawerActions()
}