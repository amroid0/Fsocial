package com.amroid.fsocial.domain.validation

sealed class CredentialValidationResult {
    object InvalidEmail : CredentialValidationResult()
    object InvalidPassword : CredentialValidationResult()
    object Valid : CredentialValidationResult()
}

