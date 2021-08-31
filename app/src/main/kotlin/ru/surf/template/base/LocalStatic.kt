package ru.surf.template.base

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.staticCompositionLocalOf
import ru.surf.template.ui.viewModels.MainViewModel

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel> { error("No MainViewModel found!") }

val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcher> { error("No Back Dispatcher provided") }
