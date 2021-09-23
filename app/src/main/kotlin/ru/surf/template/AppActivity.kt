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
import androidx.navigation.NavHostController
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

@AndroidEntryPoint
class AppActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Disable window decor fitting
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            navController = rememberNavController()

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
                        navController?.let {
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