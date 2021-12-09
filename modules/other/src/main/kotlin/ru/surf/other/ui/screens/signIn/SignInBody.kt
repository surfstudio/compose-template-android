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
package ru.surf.other.ui.screens.signIn

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.systemBarsPadding
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignInActions
import ru.surfstudio.compose.accompanist.MainScaffoldSearch
import ru.surfstudio.compose.modifier.SpaceSize
import ru.surfstudio.compose.modifier.spaceForm
import ru.surfstudio.compose.modifier.spacePageHorizontal

/**
 * Body page [SignInScreen]
 *
 * @param loading state call query to api
 * @param commonError state error response
 * @param onActions actions page
 * @param backDispatcher dispatcher press back
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SignInBody(
    loading: Boolean = false,
    commonError: String? = null,
    onActions: (SignInActions) -> Unit = {},
    backDispatcher: OnBackPressedDispatcher? = null
) {
    MainScaffoldSearch(
        modifier = Modifier.systemBarsPadding(),
        contentLoadState = loading,
        navigationIcon = Icons.Default.ArrowBack,
        navigationIconOnClick = { backDispatcher?.onBackPressed() },
        contentTitle = { TopBarContentTitle(stringResource(id = R.string.sign_in_title)) }
    ) {
        val listState = rememberScrollState()
        Column(
            modifier = Modifier
                .spacePageHorizontal()
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
                .verticalScroll(listState)
        ) {

            Spacer(modifier = Modifier.padding(bottom = SpaceSize.spacePageVertical))

            // common error
            commonError?.let {
                BoxTextFieldError(textError = it)
                Spacer(Modifier.spaceForm())
                LaunchedEffect(commonError) { listState.animateScrollTo(0) }
            }

            SignInForm(
                loading = loading,
                onActions = onActions
            )
        }
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
