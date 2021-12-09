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
package ru.surf.users.ui.screens.viewUser

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.surf.core.compose.AppSwipeRefreshIndicator
import ru.surf.core.compose.LoaderPage
import ru.surf.core.compose.PageNotFound
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.users.data.mock.userModelMock
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.actions.ViewUserActions
import ru.surfstudio.compose.accompanist.MainScaffoldSearch
import ru.surfstudio.compose.modifier.spaceLarge

/**
 * Body page [ViewUserScreen]
 *
 * @param id user identifier
 * @param model data db room [UserModel]
 * @param loading state call query to api
 * @param error404 state if model not found
 * @param onActions actions page
 * @param backDispatcher dispatcher press back
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun ViewUserBody(
    id: String,
    model: UserModel?,
    loading: Boolean = false,
    error404: Boolean = false,
    onActions: (ViewUserActions) -> Unit = {},
    backDispatcher: OnBackPressedDispatcher? = null
) {
    MainScaffoldSearch(
        modifier = Modifier.systemBarsPadding(),
        contentTitle = {
            TopBarContentTitle(model?.name ?: "")
        },
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = {
            backDispatcher?.onBackPressed()
        },
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(loading),
            onRefresh = {
                onActions(ViewUserActions.RefreshView(id))
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
                if (model is UserModel && !loading) {
                    Column(
                        modifier = Modifier
                            .spaceLarge()
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            style = MaterialTheme.typography.h6,
                            text = "Info:"
                        )

                        Spacer(modifier = Modifier.spaceLarge())

                        Text(
                            style = MaterialTheme.typography.h5,
                            text = "User name: ${model.name}"
                        )
                    }
                }
            }
            if (loading) {
                LoaderPage()
            }
            if (error404) {
                PageNotFound()
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
            ViewUserBody(
                id = userModelMock().id,
                model = userModelMock()
            )
        }
    }
}
