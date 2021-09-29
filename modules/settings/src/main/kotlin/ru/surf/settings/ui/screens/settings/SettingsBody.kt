/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.settings.ui.screens.settings

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.modifier.paddingSmall
import com.keygenqt.modifier.sizeLarge
import com.keygenqt.modifier.sizeMedium
import ru.surf.core.compose.AppSwipeRefreshIndicator
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.settings.R
import ru.surf.settings.ui.actions.SettingsActions
import ru.surf.core.R as RCore

/**
 * Body page [SettingsScreen]
 *
 * @param loading state call query to api
 * @param onActions actions page
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SettingsBody(
    loading: Boolean = false,
    onActions: (SettingsActions) -> Unit = {},
) {
    MainScaffoldSearch(
        modifier = Modifier.systemBarsPadding(),
        navigationIcon = Icons.Default.Menu,
        navigationIconOnClick = { onActions(SettingsActions.OpenMenu) },
        contentTitle = {
            TopBarContentTitle(stringResource(id = RCore.string.menu_settings))
        },
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(loading),
            onRefresh = {
                onActions(SettingsActions.UpdateSettings)
            },
            indicator = { st, tr ->
                AppSwipeRefreshIndicator(st, tr)
            },
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.sizeMedium())

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Spacer(modifier = Modifier.paddingSmall())
                    Text(
                        text = stringResource(id = R.string.settings_details_subtitle),
                        style = MaterialTheme.typography.subtitle2,
                    )
                    Spacer(modifier = Modifier.paddingSmall())
                }

                SettingsItem(text = stringResource(id = R.string.settings_details_about)) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                SettingsItem(text = stringResource(id = R.string.settings_details_edit)) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                SettingsSwitch(
                    checked = false,
                    text = stringResource(id = R.string.settings_details_enable_push)
                ) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Spacer(modifier = Modifier.paddingSmall())
                    Text(
                        text = stringResource(id = R.string.settings_info_subtitle),
                        style = MaterialTheme.typography.subtitle2,
                    )
                    Spacer(modifier = Modifier.paddingSmall())
                }

                SettingsItem(text = stringResource(id = R.string.settings_info_terms)) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                SettingsItem(text = stringResource(id = R.string.settings_info_policy)) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Spacer(modifier = Modifier.paddingSmall())
                    Text(
                        text = stringResource(id = R.string.settings_system_subtitle),
                        style = MaterialTheme.typography.subtitle2,
                    )
                    Spacer(modifier = Modifier.paddingSmall())
                }

                SettingsItem(text = stringResource(id = R.string.settings_system_appearance)) {
                }

                Spacer(modifier = Modifier.sizeMedium())

                SettingsItem(text = stringResource(id = R.string.settings_system_licences)) {
                }

                Spacer(modifier = Modifier.sizeLarge())
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .height(0.5.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.sizeLarge())

                SettingsItem(text = stringResource(id = R.string.settings_logout)) {
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            SettingsBody()
        }
    }
}
