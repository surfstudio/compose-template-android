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
package ru.surf.other.ui.screens.signUp

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.extension.EmitByStatus
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions
import ru.surfstudio.compose.accompanist.MainScaffoldSearch

/**
 * Body page [SignUpScreen]
 *
 * @param loading state call query to api
 * @param commonError state error response
 * @param commonSuccess state success validate email
 * @param onActions actions page
 * @param backDispatcher dispatcher press back
 *
 * @author Vitaliy Zarubin
 */
@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SignUpBody(
    loading: Boolean = false,
    commonError: String? = null,
    commonSuccess: Boolean? = null,
    onActions: (SignUpActions) -> Unit = {},
    backDispatcher: OnBackPressedDispatcher? = null
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)
    val localFocusManager = LocalFocusManager.current
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    backDispatcher?.EmitByStatus(status = pagerState.currentPage == 1) {
        scope.launch {
            pagerState.animateScrollToPage(0)
            localFocusManager.clearFocus()
            softwareKeyboardController?.hide()
        }
    }

    MainScaffoldSearch(
        modifier = Modifier.statusBarsPadding(),
        contentLoadState = loading,
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = {
            backDispatcher?.onBackPressed()
        },
        contentTitle = { TopBarContentTitle(stringResource(id = R.string.sign_up_title)) }
    ) {

        var dataEmail: String by remember { mutableStateOf("") }
        var dataPass: String by remember { mutableStateOf("") }

        LaunchedEffect(commonSuccess) {
            if (commonSuccess == true) {
                pagerState.animateScrollToPage(1)
            }
        }

        HorizontalPager(
            count = 2,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> SignUpFormCredential(
                    state = pagerState,
                    loading = loading,
                    commonError = commonError,
                    onActions = onActions,
                ) { email, pass ->
                    dataEmail = email
                    dataPass = pass
                }
                1 -> SignUpFormProfile(
                    state = pagerState,
                    loading = loading,
                    commonError = commonError,
                    onActions = onActions,
                    dataEmail = dataEmail,
                    dataPass = dataPass,
                )
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
            SignUpBody()
        }
    }
}
