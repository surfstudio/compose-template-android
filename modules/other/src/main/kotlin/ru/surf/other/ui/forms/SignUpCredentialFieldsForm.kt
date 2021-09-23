package ru.surf.other.ui.forms

import com.keygenqt.forms.base.FormFieldState
import com.keygenqt.forms.base.FormStates
import com.keygenqt.forms.states.EmailStateValidateRequired
import ru.surf.core.forms.validate.PasswordStateValidateRequired

enum class SignUpCredentialFieldsForm(val state: FormFieldState) : FormStates {
    SignUpEmail(EmailStateValidateRequired()),
    SignUpPassword(PasswordStateValidateRequired()),
}