/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.ui.actions

import ru.surf.other.ui.screens.signUp.SignUpScreen

/**
 * Actions sealed class for screen [SignUpScreen]
 *
 * @author Vitaliy Zarubin
 */
sealed class SignUpActions {

    /**
     * Validate email in back-end side
     *
     * @property email string
     */
    data class SignUpValidate(val email: String) : SignUpActions()

    /**
     * Action registration user
     *
     * @property email login email user
     * @property pass just password
     * @property fname string name user
     * @property lname string surname user
     * @property phoneWork string phone from work
     * @property phoneHome string phone form home
     * @property card string format ####-####-####-####
     * @property cvc string format ###
     * @property bio text about user
     */
    data class SignUp(
        val email: String,
        val pass: String,
        val fname: String,
        val lname: String,
        val phoneWork: String,
        val phoneHome: String,
        val card: String,
        val cvc: String,
        val bio: String,
    ) : SignUpActions()
}
