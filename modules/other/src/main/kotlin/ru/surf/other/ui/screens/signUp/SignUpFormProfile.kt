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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.keygenqt.forms.base.FormFieldsState
import com.keygenqt.forms.fields.FormField
import com.keygenqt.forms.fields.FormFieldPhone
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingMedium
import com.keygenqt.modifier.paddingSmall
import com.keygenqt.modifier.sizeLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.forms.SignUpProfileFieldsForm.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpFormProfile(
    loading: Boolean = false,
    commonError: String? = null,
    onActions: (SignUpActions) -> Unit = {},
    dataEmail: String = "",
    dataPass: String = "",
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

        SignUpForm(
            dataEmail = dataEmail,
            dataPass = dataPass,
            loading = loading,
            onActions = onActions
        )

        Spacer(modifier = Modifier.sizeLarge())
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SignUpForm(
    dataEmail: String = "",
    dataPass: String = "",
    loading: Boolean = false,
    onActions: (SignUpActions) -> Unit = {},
) {
    Column {
        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current

        // Create from state
        val formFields = FormFieldsState().apply {
            add(SignUpFname, remember { SignUpFname.state.default("") })
            add(SignUpLname, remember { SignUpLname.state.default("") })
            add(SignUpPhoneWork, remember { SignUpPhoneWork.state.default("") })
            add(SignUpPhoneHome, remember { SignUpPhoneHome.state.default("") })
            add(SignUpBio, remember { SignUpBio.state.default("") })
        }

        val requesterSignUpFname = remember { FocusRequester() }
        val requesterSignUpLname = remember { FocusRequester() }
        val requesterSignUpPhoneWork = remember { FocusRequester() }
        val requesterSignUpPhoneHome = remember { FocusRequester() }
        val requesterSignUpBio = remember { FocusRequester() }

        // click submit
        val submitClick = {
            // validate before send
            formFields.validate()
            // clear focuses
            localFocusManager.clearFocus()
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
                        bio = formFields.get(SignUpBio).getValue(),
                    )
                )
                // hide keyboard
                softwareKeyboardController?.hide()
            }
        }

        Spacer(modifier = Modifier.paddingSmall())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_required),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormField(
            modifier = Modifier.focusRequester(requesterSignUpFname),
            label = stringResource(id = R.string.sign_up_fname),
            enabled = !loading,
            state = formFields.get(SignUpFname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterSignUpLname.requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormField(
            modifier = Modifier.focusRequester(requesterSignUpLname),
            label = stringResource(id = R.string.sign_up_lname),
            enabled = !loading,
            state = formFields.get(SignUpLname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterSignUpPhoneWork.requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.paddingLarge())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_optional),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormFieldPhone(
            modifier = Modifier.focusRequester(requesterSignUpPhoneWork),
            label = stringResource(id = R.string.sign_up_phone_work),
            enabled = !loading,
            state = formFields.get(SignUpPhoneWork),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterSignUpPhoneHome.requestFocus() }),
            mask = "+7 (###) ###-##-##",
            placeholder = "+7 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormFieldPhone(
            modifier = Modifier.focusRequester(requesterSignUpPhoneHome),
            label = stringResource(id = R.string.sign_up_phone_home),
            enabled = !loading,
            state = formFields.get(SignUpPhoneHome),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterSignUpBio.requestFocus() }),
            mask = "+380 (###) ###-##-##",
            placeholder = "+380 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormField(
            maxLines = 5,
            singleLine = false,
            modifier = Modifier.focusRequester(requesterSignUpBio),
            label = stringResource(id = R.string.sign_up_bio),
            enabled = !loading,
            state = formFields.get(SignUpBio),
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(onNext = { submitClick.invoke() }),
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

        Spacer(modifier = Modifier.paddingMedium())
    }
}

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