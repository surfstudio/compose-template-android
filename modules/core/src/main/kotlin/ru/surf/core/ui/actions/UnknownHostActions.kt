/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.ui.actions

import ru.surf.core.ui.screens.status.StatusScreen

/**
 * Actions sealed class for screen [StatusScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class UnknownHostActions {

    /**
     * Check network status
     */
    object Repeat : UnknownHostActions()
}
