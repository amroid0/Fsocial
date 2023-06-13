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
        val amr = User("bobId","bob@friends.com","about bob")
        val password = "MaY@2021"
        val viewModel = SignupViewModel(RegexCredentialValidator()).also {
            it.createAccount(amr.email,password,amr.info)
        }
        viewModel.createAccount(amr.email,password,amr.info)
        assertEquals(SignupState.DuplicateAccount,viewModel.signupState.value)
    }
}