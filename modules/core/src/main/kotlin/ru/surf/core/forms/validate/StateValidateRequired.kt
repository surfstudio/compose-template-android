/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.forms.validate

import com.keygenqt.forms.base.FormFieldState
import com.keygenqt.forms.validation.getErrorIsBlank

/**
 * Validator if required
 *
 * @author Vitaliy Zarubin
 */
class StateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
    )
})
