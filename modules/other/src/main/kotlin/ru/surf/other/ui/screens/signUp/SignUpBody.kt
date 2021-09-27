/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
import com.keygenqt.accompanist.MainScaffoldSearch
import kotlinx.coroutines.launch
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.extension.EmitByStatus
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions

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
    val pagerState = rememberPagerState(pageCount = 2)
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
            dragEnabled = false,
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
