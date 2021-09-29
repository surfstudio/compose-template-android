/**
 * Copyright 2021 Surf
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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.keygenqt.forms.base.FormFieldsState
import com.keygenqt.forms.fields.FormFieldEmail
import com.keygenqt.forms.fields.FormFieldPassword
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.sizeLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.theme.MainAppTheme
import ru.surf.core.utils.ConstantsApp
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.forms.SignUpCredentialFieldsForm.SignUpEmail
import ru.surf.other.ui.forms.SignUpCredentialFieldsForm.SignUpPassword

/**
 * Form page [SignUpBody]
 *
 * @param state page view state
 * @param loading state call query to api
 * @param commonError state error response
 * @param onActions actions page
 * @param savedData callback success result
 *
 * @author Vitaliy Zarubin
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpFormCredential(
    state: PagerState = rememberPagerState(pageCount = 0),
    loading: Boolean = false,
    commonError: String? = null,
    onActions: (SignUpActions) -> Unit = {},
    savedData: (email: String, pass: String) -> Unit = { _, _ -> }
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

        // to top list
        LaunchedEffect(state.currentPage) {
            listState.animateScrollTo(0)
        }

        SignUpForm(
            state = state,
            loading = loading,
            onActions = onActions,
            savedData = savedData,
        )

        Spacer(modifier = Modifier.sizeLarge())
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
@Composable
private fun SignUpForm(
    state: PagerState,
    loading: Boolean = false,
    onActions: (SignUpActions) -> Unit = {},
    savedData: (email: String, pass: String) -> Unit = { _, _ -> }
) {
    Column {
        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current
        val scope = rememberCoroutineScope()

        // create from state
        val formFields = FormFieldsState().apply {
            add(SignUpEmail, remember { SignUpEmail.state.default(ConstantsApp.DEBUG_CREDENTIAL_LOGIN) })
            add(SignUpPassword, remember { SignUpPassword.state.default(ConstantsApp.DEBUG_CREDENTIAL_PASSW) })
        }

        // clear error
        LaunchedEffect(state.currentPage) {
            formFields.clearError()
        }

        // click submit
        val submitClick = {
            // validate before send
            formFields.validate()
            // clear focuses
            localFocusManager.clearFocus()
            // check has errors
            if (!formFields.hasErrors()) {
                // submit query
                savedData.invoke(
                    formFields.get(SignUpEmail).getValue(),
                    formFields.get(SignUpPassword).getValue(),
                )
                onActions(
                    SignUpActions.SignUpValidate(formFields.get(SignUpEmail).getValue())
                )
                // hide keyboard
                softwareKeyboardController?.hide()
            }
        }

        // Create field email
        FormFieldEmail(
            label = stringResource(id = R.string.sign_in_form_email),
            enabled = !loading,
            state = formFields.get(SignUpEmail),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpPassword).requestFocus() })
        )

        Spacer(modifier = Modifier.paddingLarge())

        // Create field password
        FormFieldPassword(
            enabled = !loading,
            state = formFields.get(SignUpPassword),
            imeAction = ImeAction.Done,
            tintIcon = MaterialTheme.colors.onPrimary,
            keyboardActions = KeyboardActions(onDone = { submitClick.invoke() })
        )

        Spacer(modifier = Modifier.paddingLarge())

        // Submit button
        Button(
            enabled = !loading,
            onClick = { submitClick.invoke() },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
        ) {
            Text(
                text = stringResource(id = R.string.sign_in_form_button_submit).uppercase(),
            )
        }

        // Clear focus after end
        LaunchedEffect(Unit) {
            scope.launch {
                delay(10)
                formFields.get(SignUpEmail).requestFocus()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            SignUpFormCredential()
        }
    }
}
