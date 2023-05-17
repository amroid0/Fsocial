package com.amroid.fsocial.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {
    private val _mutableSignupState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignupState

    fun createAccount(email: String, password: String, info: String) {
        _mutableSignupState.value = SignupState.BadEmail
    }

}
