package ru.surf.other.ui.screens.signIn

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.keygenqt.accompanist.MainScaffoldSearch
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.other.R
import ru.surf.other.ui.actions.SignInActions

@Composable
fun SignInBody(
    onActions: (SignInActions) -> Unit = {},
) {
    val backDispatcher = LocalBackPressedDispatcher.current

    MainScaffoldSearch(
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = { backDispatcher.onBackPressed() },
        contentTitle = { TopBarContentTitle(stringResource(id = R.string.sign_in_title)) }
    ) {

    }
}
