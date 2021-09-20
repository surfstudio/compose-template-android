package ru.surf.other.ui.screens.signIn

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.keygenqt.accompanist.MainScaffoldSearch
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.screens.welcome.WelcomeBody

@Composable
fun SignInBody(
    onActions: (SignInActions) -> Unit = {},
    backDispatcher: OnBackPressedDispatcher? = null
) {
    MainScaffoldSearch(
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = { backDispatcher?.onBackPressed() },
        contentTitle = { TopBarContentTitle(stringResource(id = R.string.sign_in_title)) }
    ) {

    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            SignInBody()
        }
    }
}