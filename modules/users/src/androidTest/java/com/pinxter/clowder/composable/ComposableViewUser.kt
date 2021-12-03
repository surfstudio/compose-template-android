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
package com.pinxter.clowder.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.screens.viewUser.ViewUserBody
import java.util.*

@RunWith(AndroidJUnit4::class)
class ComposableViewUser {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_view_user_page() {
        // Arrange
        composeTestRule.setContent {
            with(UserModel(UUID.randomUUID().toString(), "First")) {
                ViewUserBody(id, this)
            }
        }
        // Act
        val result = composeTestRule.onNodeWithText("User name: First")
        // Assert
        result.assertIsDisplayed()
    }
}
