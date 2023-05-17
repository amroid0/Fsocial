package com.amroid.fsocial.signup

import com.amroid.fsocial.InstantExecutorExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class InputValidationTest {
    @Test
    fun invalidEmail(){
        val viewModel =SignupViewModel()
        viewModel.createAccount("email",":password",":info")
        assertEquals(SignupState.BadEmail,viewModel.signupState.value)
    }

}