package ru.surf.other.navigation.actions.impl

import androidx.navigation.NavHostController
import ru.surf.other.navigation.nav.OtherNav

interface WelcomeScreenActions {

    val controller: NavHostController

    fun toSignIn() {
        controller.navigate(OtherNav.SignInNav.SignInNavScreen.route)
    }

    fun toSignUp() {
        controller.navigate(OtherNav.SignUpNav.SignUpNavScreen.route)
    }
}