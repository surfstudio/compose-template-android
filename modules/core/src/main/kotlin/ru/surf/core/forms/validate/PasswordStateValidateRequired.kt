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
package ru.surf.core.forms.validate

import android.content.Context
import ru.surf.core.R
import ru.surfstudio.compose.forms.base.FormFieldState
import ru.surfstudio.compose.forms.validation.getErrorIsBlank
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
