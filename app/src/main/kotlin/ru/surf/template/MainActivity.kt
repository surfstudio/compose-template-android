package ru.surf.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.surf.template.base.LocalBackPressedDispatcher
import ru.surf.template.base.LocalMainViewModel
import ru.surf.template.navigation.NavGraph
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
                    NavGraph(rememberNavController())
                }
            }
        }
    }
}