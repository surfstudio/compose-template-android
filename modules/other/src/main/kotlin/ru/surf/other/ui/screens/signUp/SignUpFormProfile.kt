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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.forms.SignUpProfileFieldsForm.*
import ru.surfstudio.compose.forms.base.FormFieldsState
import ru.surfstudio.compose.forms.fields.FormField
import ru.surfstudio.compose.forms.fields.FormFieldNumber
import ru.surfstudio.compose.forms.fields.FormFieldPhone
import ru.surfstudio.compose.modifier.*

/**
 * Form page [SignUpBody]
 *
 * @param state page view state
 * @param loading state call query to api
 * @param commonError state error response
 * @param onActions actions page
 * @param dataEmail data email from first page after validate
 * @param dataPass data password from first page after validate
 *
 * @author Vitaliy Zarubin
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpFormProfile(
    state: PagerState = rememberPagerState(initialPage = 0),
    loading: Boolean = false,
    commonError: String? = null,
    onActions: (SignUpActions) -> Unit = {},
    dataEmail: String = "",
    dataPass: String = "",
) {
    val listState = rememberScrollState()

    Column(
        modifier = Modifier
            .spacePageHorizontal()
            .background(MaterialTheme.colors.background)
            .navigationBarsWithImePadding()
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

        // to top list
        LaunchedEffect(state.currentPage) {
            listState.animateScrollTo(0)
        }

        SignUpForm(
            state = state,
            dataEmail = dataEmail,
            dataPass = dataPass,
            loading = loading,
            onActions = onActions
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
@Composable
private fun SignUpForm(
    state: PagerState,
    dataEmail: String = "",
    dataPass: String = "",
    loading: Boolean = false,
    onActions: (SignUpActions) -> Unit = {},
) {
    Column(
        modifier = Modifier
    ) {

        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current

        // create from state
        val formFields = FormFieldsState().apply {
            add(SignUpFname, remember { SignUpFname.state.default("") })
            add(SignUpLname, remember { SignUpLname.state.default("") })
            add(SignUpPhoneWork, remember { SignUpPhoneWork.state.default("") })
            add(SignUpPhoneHome, remember { SignUpPhoneHome.state.default("") })
            add(SignUpCard, remember { SignUpCard.state.default("") })
            add(SignUpCvc, remember { SignUpCvc.state.default("") })
            add(SignUpBio, remember { SignUpBio.state.default("") })
        }

        // clear error
        LaunchedEffect(state.currentPage) {
            formFields.clearError()
        }

        // click submit
        val submitClick = {
            // clear focuses
            localFocusManager.clearFocus()
            // validate before send
            formFields.validate()
            // check has errors
            if (!formFields.hasErrors()) {
                // submit query
                onActions(
                    SignUpActions.SignUp(
                        email = dataEmail,
                        pass = dataPass,
                        fname = formFields.get(SignUpFname).getValue(),
                        lname = formFields.get(SignUpLname).getValue(),
                        phoneWork = formFields.get(SignUpPhoneWork).getValue(),
                        phoneHome = formFields.get(SignUpPhoneHome).getValue(),
                        card = formFields.get(SignUpCard).getValue(),
                        cvc = formFields.get(SignUpCvc).getValue(),
                        bio = formFields.get(SignUpBio).getValue(),
                    )
                )
                // hide keyboard
                softwareKeyboardController?.hide()
            }
        }

        Spacer(modifier = Modifier.spaceSmall())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_info),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.spaceSmall())

        FormField(
            label = stringResource(id = R.string.sign_up_required_fname),
            enabled = !loading,
            state = formFields.get(SignUpFname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpLname).requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.spaceForm())

        FormField(
            label = stringResource(id = R.string.sign_up_required_lname),
            enabled = !loading,
            state = formFields.get(SignUpLname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpPhoneWork).requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.spaceForm())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_connection),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.spaceSmall())

        FormFieldPhone(
            label = stringResource(id = R.string.sign_up_required_phone_work),
            enabled = !loading,
            state = formFields.get(SignUpPhoneWork),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpPhoneHome).requestFocus() }),
            mask = "+7 (###) ###-##-##",
            placeholder = "+7 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.spaceForm())

        FormFieldPhone(
            label = stringResource(id = R.string.sign_up_phone_home),
            enabled = !loading,
            state = formFields.get(SignUpPhoneHome),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpCard).requestFocus() }),
            mask = "+380 (###) ###-##-##",
            placeholder = "+380 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.spaceForm())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_payment),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.spaceSmall())

        FormFieldNumber(
            label = stringResource(id = R.string.sign_up_number_card),
            enabled = !loading,
            state = formFields.get(SignUpCard),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpCvc).requestFocus() }),
            mask = "####-####-####-####",
            placeholder = "0000-0000-0000-0000",
        )

        Spacer(modifier = Modifier.spaceForm())

        FormFieldNumber(
            label = stringResource(id = R.string.sign_up_cvc),
            enabled = !loading,
            state = formFields.get(SignUpCvc),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpBio).requestFocus() }),
            mask = "###",
            placeholder = "000",
        )

        Spacer(modifier = Modifier.spaceForm())

        Text(
            text = stringResource(id = R.string.sign_up_bio),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.spaceSmall())

        FormField(
            lines = 3,
            maxLines = 5,
            singleLine = false,
            enabled = !loading,
            state = formFields.get(SignUpBio),
            imeAction = ImeAction.Default,
        )

        Spacer(modifier = Modifier.spaceForm())

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

        Spacer(modifier = Modifier.padding(bottom = SpaceSize.spacePageVertical))
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            SignUpFormProfile()
        }
    }
}
