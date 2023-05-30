package com.amroid.fsocial.signup

import com.amroid.fsocial.InstantExecutorExtension
import com.amroid.fsocial.domain.validation.CredentialValidationResult
import com.amroid.fsocial.domain.validation.RegexCredentialValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(InstantExecutorExtension::class)
class InputValidationTest {
    @Test
    fun invalidEmail() {
        val viewModel = SignupViewModel(RegexCredentialValidator())
        viewModel.createAccount("email", ":password", ":info")
        assertEquals(SignupState.BadEmail, viewModel.signupState.value)
    }

    @ParameterizedTest
    @CsvSource("''", "'  '", "'12345678'")
    fun invalidPassword(password: String) {
        val viewModel = SignupViewModel(RegexCredentialValidator())
        viewModel.createAccount("anna@friends.com", "", ":about:")
        assertEquals(SignupState.BadPassword, viewModel.signupState.value)
    }

    @Test
    fun validCredentials() {
        val validatior = RegexCredentialValidator()
        val result = validatior.validate("john@friends.com", "12ABcd3!^")
        assertEquals(result, CredentialValidationResult.Valid)
    }
}
