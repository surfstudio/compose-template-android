/*
 * Copyright Surf - All Rights Reserved
 * September 2021
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
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.keygenqt.accompanist.MainScaffoldSearch
import com.keygenqt.modifier.sizeLarge
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.compose.TopBarContentTitle
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignInActions

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
                .padding(start = 16.dp, end = 16.dp)
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
                .verticalScroll(listState)
        ) {

            Spacer(modifier = Modifier.sizeLarge())

            // common error
            commonError?.let {
                BoxTextFieldError(textError = it)
                Spacer(Modifier.sizeLarge())
                LaunchedEffect(commonError) { listState.animateScrollTo(0) }
            }

            SignInForm(
                loading = loading,
                onActions = onActions
            )

            Spacer(modifier = Modifier.sizeLarge())
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
