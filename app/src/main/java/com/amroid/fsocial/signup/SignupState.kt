package com.amroid.fsocial.signup

sealed class SignupState {
    object BadEmail : SignupState()
    object BadPassword : SignupState()
}
