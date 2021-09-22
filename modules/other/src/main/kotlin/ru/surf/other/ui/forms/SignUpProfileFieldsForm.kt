package ru.surf.other.ui.forms

import com.keygenqt.forms.base.FormFieldState
import com.keygenqt.forms.base.FormStates
import ru.surf.core.forms.validate.StateValidateRequired

enum class SignUpProfileFieldsForm(val state: FormFieldState) : FormStates {
    SignUpFname(StateValidateRequired()),
    SignUpLname(StateValidateRequired()),
    SignUpPhoneWork(StateValidateRequired()),
    SignUpPhoneHome(FormFieldState()),
    SignUpCard(FormFieldState()),
    SignUpCvc(FormFieldState()),
    SignUpBio(FormFieldState()),
}