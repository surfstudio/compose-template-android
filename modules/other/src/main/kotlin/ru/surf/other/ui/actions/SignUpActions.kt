package ru.surf.other.ui.actions

sealed class SignUpActions {
    data class SignUpValidate(val email: String) : SignUpActions()
    data class SignUp(
        val email: String,
        val pass: String,
        val fname: String,
        val lname: String,
        val phoneWork: String,
        val phoneHome: String,
        val bio: String,
    ) : SignUpActions()
}