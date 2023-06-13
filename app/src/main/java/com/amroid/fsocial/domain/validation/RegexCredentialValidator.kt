package com.amroid.fsocial.domain.validation

import java.util.regex.Pattern

class RegexCredentialValidator {
    companion object {
        private const val EMAIL_REGEX =
            """[a-zA-Z0-9+._%\-]{1,64}@[a-zA-Z0-9][a-zA-Z0-9\-]{1,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{1,25})"""
        private val emailPattern = Pattern.compile(EMAIL_REGEX)
        private const val PASSWORD_REGEX =
            """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*+=\-]).{8,}$"""
        private val passwordPattern = Pattern.compile(PASSWORD_REGEX)
    }

    fun validate(email: String, password: String): CredentialValidationResult {

        val result = if (!emailPattern.matcher(email).matches()) {
            CredentialValidationResult.InvalidEmail
        } else if (!passwordPattern.matcher(password).matches()) {
            CredentialValidationResult.InvalidPassword
        } else CredentialValidationResult.Valid
        return result
    }
}