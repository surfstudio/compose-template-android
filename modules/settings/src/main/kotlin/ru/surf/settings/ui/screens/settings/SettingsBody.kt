package ru.surf.settings.ui.screens.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.systemBarsPadding
import com.keygenqt.accompanist.MainScaffoldSearch
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.settings.R
import ru.surf.settings.ui.actions.SettingsActions

@Composable
fun ListSettingsBody(
    onActions: (SettingsActions) -> Unit = {},
) {
    MainScaffoldSearch(
        modifier = Modifier.systemBarsPadding(),
        navigationIcon = Icons.Default.Menu,
        navigationIconOnClick = { onActions(SettingsActions.OpenMenu) },
        contentTitle = {
            TopBarContentTitle(stringResource(id = R.string.settings_title))
        },
    ) {

    }
}
