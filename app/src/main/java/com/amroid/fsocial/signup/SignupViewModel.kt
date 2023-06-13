package com.amroid.fsocial.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amroid.fsocial.domain.validation.CredentialValidationResult
import com.amroid.fsocial.domain.validation.RegexCredentialValidator

class SignupViewModel(val regexCredentialValidator: RegexCredentialValidator) : ViewModel() {
    private val _mutableSignupState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignupState

    fun createAccount(email: String, password: String, info: String) {
        when (regexCredentialValidator.validate(email, password)) {
            CredentialValidationResult.InvalidEmail ->
                _mutableSignupState.value = SignupState.BadEmail
            CredentialValidationResult.InvalidPassword ->
                _mutableSignupState.value = SignupState.BadPassword

            else -> {}
        }
    }
}