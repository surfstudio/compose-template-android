/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.base

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.room.RoomDatabase

/**
 * [MainViewModel] Can be used in CompositionLocalProvider to provide values.
 *
 * @author Vitaliy Zarubin
 */
val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> { error("No MainViewModel found!") }

/**
 * [OnBackPressedDispatcher] Can be used in CompositionLocalProvider to provide values.
 *
 * @author Vitaliy Zarubin
 */
val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcher> { error("No Back Dispatcher provided") }
