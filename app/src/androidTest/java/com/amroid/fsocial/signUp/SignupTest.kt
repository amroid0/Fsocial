package com.amroid.fsocial.signUp

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.amroid.fsocial.MainActivity
import org.junit.Rule
import org.junit.Test

class SignupTest {

    @get:Rule
    val signUpTestRule = createAndroidComposeRule<MainActivity>()
    @Test
    fun performSignup(){
        launchSignupScreen(signUpTestRule){
            typeEmail("amr@gmail.com")
            typePassword("123")
            performSignup()
        } verfiy {
            timeLineScreenIsDisplay()
        }
    }
}