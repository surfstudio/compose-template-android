package ru.surf.other.ui.screens.signIn

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
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
import com.keygenqt.forms.base.FormFieldsState
import com.keygenqt.forms.fields.FormFieldEmail
import com.keygenqt.forms.fields.FormFieldPassword
import com.keygenqt.modifier.paddingLarge
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.surf.core.theme.MainAppTheme
import ru.surf.core.utils.ConstantsApp
import ru.surf.other.R
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.forms.SignInFieldsForm.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInForm(
    loading: Boolean = false,
    onActions: (SignInActions) -> Unit = {},
) {
    Column {
        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current
        val scope = rememberCoroutineScope()

        // Create from state
        val formFields = FormFieldsState().apply {
            add(SignInEmail, remember { SignInEmail.state.default(ConstantsApp.DEBUG_CREDENTIAL_LOGIN) })
            add(SignInPassword, remember { SignInPassword.state.default(ConstantsApp.DEBUG_CREDENTIAL_PASSW) })
        }

        val requesterFieldEmail = remember { FocusRequester() }
        val requesterFieldPassword = remember { FocusRequester() }

        // click submit
        val submitClick = {
            // validate before send
            formFields.validate()
            // check has errors
            if (!formFields.hasErrors()) {
                // submit query
                onActions(
                    SignInActions.SignIn(
                        email = formFields.get(SignInEmail).getValue(),
                        pass = formFields.get(SignInPassword).getValue(),
                    )
                )
                // hide keyboard
                localFocusManager.clearFocus()
                softwareKeyboardController?.hide()
            }
        }

        // Create field email
        FormFieldEmail(
            modifier = Modifier.focusRequester(requesterFieldEmail),
            label = stringResource(id = R.string.sign_in_form_email),
            enabled = !loading,
            state = formFields.get(SignInEmail),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterFieldPassword.requestFocus() })
        )

        Spacer(modifier = Modifier.paddingLarge())

        // Create field password
        FormFieldPassword(
            modifier = Modifier.focusRequester(requesterFieldPassword),
            enabled = !loading,
            state = formFields.get(SignInPassword),
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
                requesterFieldEmail.requestFocus()
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
            SignInForm()
        }
    }
}