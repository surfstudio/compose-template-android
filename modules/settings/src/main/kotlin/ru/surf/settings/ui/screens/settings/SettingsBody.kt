/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
import ru.surf.core.compose.AppSwipeRefreshIndicator
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.settings.R
import ru.surf.settings.ui.actions.SettingsActions
import ru.surfstudio.compose.accompanist.MainScaffoldSearch
import ru.surfstudio.compose.modifier.spacePageHorizontal
import ru.surfstudio.compose.modifier.spacePageVertical
import ru.surfstudio.compose.modifier.spaceSmall
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
                Column(Modifier.spacePageVertical()) {

                    Column(Modifier.spacePageHorizontal()) {
                        Spacer(modifier = Modifier.spaceSmall())
                        Text(
                            text = stringResource(id = R.string.settings_details_subtitle),
                            style = MaterialTheme.typography.subtitle2,
                        )
                        Spacer(modifier = Modifier.spaceSmall())
                    }

                    SettingsItem(text = stringResource(id = R.string.settings_details_about)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    SettingsItem(text = stringResource(id = R.string.settings_details_edit)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    SettingsSwitch(
                        checked = false,
                        text = stringResource(id = R.string.settings_details_enable_push)
                    ) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    Column(Modifier.spacePageHorizontal()) {
                        Spacer(modifier = Modifier.spaceSmall())
                        Text(
                            text = stringResource(id = R.string.settings_info_subtitle),
                            style = MaterialTheme.typography.subtitle2,
                        )
                        Spacer(modifier = Modifier.spaceSmall())
                    }

                    SettingsItem(text = stringResource(id = R.string.settings_info_terms)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    SettingsItem(text = stringResource(id = R.string.settings_info_policy)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    Column(Modifier.spacePageHorizontal()) {
                        Spacer(modifier = Modifier.spaceSmall())
                        Text(
                            text = stringResource(id = R.string.settings_system_subtitle),
                            style = MaterialTheme.typography.subtitle2,
                        )
                        Spacer(modifier = Modifier.spaceSmall())
                    }

                    SettingsItem(text = stringResource(id = R.string.settings_system_appearance)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())

                    SettingsItem(text = stringResource(id = R.string.settings_system_licences)) {
                    }

                    Spacer(modifier = Modifier.spaceSmall())
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
                    Spacer(modifier = Modifier.spaceSmall())

                    SettingsItem(text = stringResource(id = R.string.settings_logout)) {
                    }
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
