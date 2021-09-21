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
import ru.surf.other.ui.forms.SignUpCredentialFieldsForm.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpFormCredential(
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

        SignUpForm(
            loading = loading,
            onActions = onActions,
            savedData = savedData,
        )

        Spacer(modifier = Modifier.sizeLarge())
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SignUpForm(
    loading: Boolean = false,
    onActions: (SignUpActions) -> Unit = {},
    savedData: (email: String, pass: String) -> Unit = { _, _ -> }
) {
    Column {
        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current
        val scope = rememberCoroutineScope()

        // Create from state
        val formFields = FormFieldsState().apply {
            add(SignUpEmail, remember { SignUpEmail.state.default(ConstantsApp.DEBUG_CREDENTIAL_LOGIN) })
            add(SignUpPassword, remember { SignUpPassword.state.default(ConstantsApp.DEBUG_CREDENTIAL_PASSW) })
        }

        val requesterFieldEmail = remember { FocusRequester() }
        val requesterFieldPassword = remember { FocusRequester() }

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
            modifier = Modifier.focusRequester(requesterFieldEmail),
            label = stringResource(id = R.string.sign_in_form_email),
            enabled = !loading,
            state = formFields.get(SignUpEmail),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { requesterFieldPassword.requestFocus() })
        )

        Spacer(modifier = Modifier.paddingLarge())

        // Create field password
        FormFieldPassword(
            modifier = Modifier.focusRequester(requesterFieldPassword),
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
            SignUpFormCredential()
        }
    }
}