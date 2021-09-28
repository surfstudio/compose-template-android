/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.forms.validate

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.keygenqt.forms.base.FormFieldState
import com.keygenqt.forms.validation.getErrorIsBlank
import ru.surf.core.R
import java.util.regex.Pattern

/**
 * Regex check password
 */
private const val PASSWORD_VALIDATION_REGEX = """^[0-9_A-z]+$"""

/**
 * Validator for password
 *
 * @author Vitaliy Zarubin
 */
class PasswordStateValidateRequired : FormFieldState(checkValid = { target: String ->
    listOfNotNull(
        getErrorIsBlank(target),
        getErrorIsSmall(target),
        getErrorIsLong(target),
        getErrorIsNotMatches(target),
    )
})

/**
 * Validate length password for [PasswordStateValidateRequired]
 *
 * @author Vitaliy Zarubin
 */
private fun getErrorIsSmall(target: String) =
    when {
        target.length < 6 -> { it: Context ->
            it.getString(R.string.error_field_min_length, "6")
        }
        else -> null
    }

/**
 * Validate length password for [PasswordStateValidateRequired]
 *
 * @author Vitaliy Zarubin
 */
private fun getErrorIsLong(target: String) =
    when {
        target.length > 12 -> { it: Context ->
            it.getString(R.string.error_field_max_length, "12")
        }
        else -> null
    }

/**
 * Check password by regex [PasswordStateValidateRequired]
 *
 * @author Vitaliy Zarubin
 */
private fun getErrorIsNotMatches(target: String) =
    when {
        !Pattern.matches(PASSWORD_VALIDATION_REGEX, target) -> { it: Context ->
            it.getString(R.string.is_incorrect)
        }
        else -> null
    }
