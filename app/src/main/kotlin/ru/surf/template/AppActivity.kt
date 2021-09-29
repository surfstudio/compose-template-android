/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.template

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.core.base.LocalMainViewModel
import ru.surf.core.base.MainViewModel
import ru.surf.core.theme.MainAppTheme
import ru.surf.template.navigation.NavGraph
import ru.surf.template.navigation.NavGraphGuest
import ru.surf.template.navigation.NavGraphMain

/**
 * This is the main and only Activity
 *
 * @author Vitaliy Zarubin
 */
@AndroidEntryPoint
class AppActivity : ComponentActivity() {

    /**
     * Main ViewModel which is available throughout the application as staticCompositionLocalOf
     */
    private val viewModel: MainViewModel by viewModels()

    /**
     * Main initialization point of view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Disable window decor fitting
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // compose initialization
        setContent {
            CompositionLocalProvider(
                LocalMainViewModel provides viewModel,
                LocalBackPressedDispatcher provides this.onBackPressedDispatcher
            ) {
                MainAppTheme {
                    ProvideWindowInsets {
                        // observe changes
                        val isLogin by viewModel.isLogin.collectAsState(null)
                        val hasNetwork by viewModel.hasNetwork.collectAsState()
                        // select graph
                        rememberNavController()?.let {
                            if (!hasNetwork) {
                                NavGraphMain(it)
                            } else {
                                when (isLogin) {
                                    true -> NavGraph(it)
                                    false -> NavGraphGuest(it)
                                }
                            }
                        }
                    }
                }
            }
        }

        // Splash delay
        window.decorView.findViewById<View>(android.R.id.content)?.let { content ->
            content.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (viewModel.isReady.value) {
                            // remove BG splash
                            this@AppActivity.window.decorView.setBackgroundColor(Color.WHITE)
                            // done splash remove listener
                            content.viewTreeObserver.removeOnPreDrawListener(this); true
                        } else false
                    }
                }
            )
        }
    }
}
