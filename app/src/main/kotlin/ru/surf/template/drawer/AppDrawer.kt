package ru.surf.template.drawer

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.systemBarsPadding
import com.keygenqt.modifier.sizeMedium
import kotlinx.coroutines.launch
import ru.surf.core.extension.EmitByStatus
import ru.surf.core.theme.MainAppTheme
import ru.surf.settings.navigation.nav.SettingsNav
import ru.surf.users.navigation.nav.UsersNav

@Composable
fun AppDrawer(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    currentRoute: String = UsersNav.MainNav.ListUsersScreen.route,
    backDispatcher: OnBackPressedDispatcher? = null,
    onActions: (AppDrawerActions) -> Unit = {},
) {
    val scope = rememberCoroutineScope()

    backDispatcher?.EmitByStatus(scaffoldState.drawerState.isOpen) {
        scope.launch { scaffoldState.drawerState.close() }
    }

    val onClick: (AppDrawerActions) -> () -> Unit = { event ->
        {
            onActions(event)
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }

    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.sizeMedium())

        AppDrawerItem(
            isSelected = currentRoute == UsersNav.MainNav.ListUsersScreen.route,
            label = "Members",
            icon = Icons.Filled.People,
            onClick = onClick(AppDrawerActions.ToUsers)
        )

        AppDrawerItem(
            isSelected = currentRoute == SettingsNav.MainNav.SettingsScreen.route,
            label = "Settings",
            icon = Icons.Filled.Settings,
            onClick = onClick(AppDrawerActions.ToSettings)
        )
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Column(
            Modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxSize()
        ) {
            AppDrawer()
        }
    }
}