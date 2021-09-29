/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.forms

import com.keygenqt.forms.base.FormFieldState
import com.keygenqt.forms.base.FormStates
import ru.surf.core.forms.validate.StateValidateRequired

/**
 * Form state for registration
 *
 * @author Vitaliy Zarubin
 */
enum class SignUpProfileFieldsForm(val state: FormFieldState) : FormStates {
    SignUpFname(StateValidateRequired()),
    SignUpLname(StateValidateRequired()),
    SignUpPhoneWork(StateValidateRequired()),
    SignUpPhoneHome(FormFieldState()),
    SignUpCard(FormFieldState()),
    SignUpCvc(FormFieldState()),
    SignUpBio(FormFieldState()),
}
