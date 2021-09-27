/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.navigation.actions

import ru.surf.other.navigation.actions.impl.SignInScreenActions
import ru.surf.other.navigation.actions.impl.SignUpScreenActions
import ru.surf.other.navigation.actions.impl.WelcomeScreenActions

interface OtherNavActions :
    SignInScreenActions,
    SignUpScreenActions,
    WelcomeScreenActions
