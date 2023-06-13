package com.amroid.fsocial.signup

import com.amroid.fsocial.domain.User

sealed class SignupState {
    data class Signup(val user: User) : SignupState()
    object DuplicateAccount : SignupState()

    object BadEmail : SignupState()
    object BadPassword : SignupState()
}
