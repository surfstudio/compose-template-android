package ru.surf.core.base

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.staticCompositionLocalOf

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> { error("No MainViewModel found!") }

val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcher> { error("No Back Dispatcher provided") }
