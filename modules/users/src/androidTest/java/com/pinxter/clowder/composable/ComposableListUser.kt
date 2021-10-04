package com.pinxter.clowder.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.flow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.surf.users.data.models.UserModel
import ru.surf.users.ui.screens.listUsers.ListUsersBody
import java.util.*

@RunWith(AndroidJUnit4::class)
class ComposableListUser {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_list() {
        // Arrange
        composeTestRule.setContent {
            ListUsersBody(
                search = null,
                localMainViewModel = null,
                items = flow {
                    emit(
                        PagingData.from(
                            listOf(
                                UserModel(UUID.randomUUID().toString(), "First"),
                                UserModel(UUID.randomUUID().toString(), "Second"),
                            )
                        )
                    )
                }.collectAsLazyPagingItems(),
                searchItems = flow {
                    emit(PagingData.empty<UserModel>())
                }.collectAsLazyPagingItems()
            )
        }
        // Act
        val result = listOfNotNull(
            composeTestRule.onNodeWithText("First".uppercase()),
            composeTestRule.onNodeWithText("Second".uppercase())
        )
        // Assert
        result.forEach {
            it.assertIsDisplayed()
        }
    }

    @Test
    fun check_list_search() {
        // Arrange
        composeTestRule.setContent {
            ListUsersBody(
                search = "search",
                localMainViewModel = null,
                items = flow {
                    emit(PagingData.empty<UserModel>())
                }.collectAsLazyPagingItems(),
                searchItems = flow {
                    emit(
                        PagingData.from(
                            listOf(
                                UserModel(UUID.randomUUID().toString(), "First"),
                                UserModel(UUID.randomUUID().toString(), "Second"),
                            )
                        )
                    )
                }.collectAsLazyPagingItems()
            )
        }
        // Act
        val result = listOfNotNull(
            composeTestRule.onNodeWithText("First".uppercase()),
            composeTestRule.onNodeWithText("Second".uppercase())
        )
        // Assert
        result.forEach {
            it.assertIsDisplayed()
        }
    }

    @Test
    fun check_list_empty() {
        // Arrange
        composeTestRule.setContent {
            ListUsersBody(
                search = null,
                localMainViewModel = null,
                items = flow {
                    emit(PagingData.empty<UserModel>())
                }.collectAsLazyPagingItems(),
                searchItems = flow {
                    emit(PagingData.empty<UserModel>())
                }.collectAsLazyPagingItems()
            )
        }
        // Act
        val result = composeTestRule.onNode(hasTestTag("Animation not found"))
        // Assert
        result.assertIsDisplayed()
    }
}