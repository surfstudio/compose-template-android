package ru.surf.template

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.surf.template.base.LocalBackPressedDispatcher
import ru.surf.template.base.LocalMainViewModel
import ru.surf.template.navigation.NavGraph
import ru.surf.template.navigation.NavGraphGuest
import ru.surf.template.ui.theme.TemplateTheme
import ru.surf.template.ui.viewModels.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalMainViewModel provides viewModel,
                LocalBackPressedDispatcher provides this.onBackPressedDispatcher
            ) {
                TemplateTheme {
                    // change status bar color
                    this@MainActivity.window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                    // select graph
                    val isLogin by viewModel.isLogin.collectAsState(null)
                    when (isLogin) {
                        true -> NavGraph(rememberNavController())
                        false -> NavGraphGuest(rememberNavController())
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
                            this@MainActivity.window.decorView.setBackgroundColor(Color.WHITE)
                            // done splash remove listener
                            content.viewTreeObserver.removeOnPreDrawListener(this); true
                        } else false
                    }
                }
            )
        }
    }
}