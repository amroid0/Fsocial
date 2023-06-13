package com.amroid.fsocial.signup

import com.amroid.fsocial.InstantExecutorExtension
import com.amroid.fsocial.domain.User
import com.amroid.fsocial.domain.validation.RegexCredentialValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class CreateAnAccountTest {
    @Test
    fun accountCreated(){
        val viewModel = SignupViewModel(RegexCredentialValidator())
        val amr = User("bobId","bob@friends.com","about bob")
        viewModel.createAccount(amr.email,"MaY@2021",amr.info)
        assertEquals(SignupState.Signup(amr),viewModel.signupState.value)
    }
}