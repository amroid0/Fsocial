package com.amroid.fsocial.signUp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.amroid.fsocial.MainActivity
import com.amroid.fsocial.R

fun launchSignupScreen(
    rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: SignupAction.() -> Unit
): SignupAction {
    return SignupAction(rule).apply(block)
}

class SignupAction(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {

    fun typeEmail(email: String) {
        val emailHint = rule.activity.getString(R.string.email)
        rule.onNodeWithText(emailHint).performTextInput(email)
    }

    fun typePassword(password: String) {
        val passwordHint = rule.activity.getString(R.string.password)
        rule.onNodeWithText(passwordHint).performTextInput(password)
    }

    fun submit() {
        val signUp = rule.activity.getString(R.string.signup)
        rule.onNodeWithText(signUp).performClick()
    }

    infix fun verfiy(
        block: SignupVerifcation.() -> Unit
    ): SignupVerifcation {
        return SignupVerifcation(rule).apply(block)
    }
}

class SignupVerifcation(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun timeLineScreenIsDisplay() {
        val timeline = rule.activity.getString(R.string.timeLine)
        rule.onNodeWithText(timeline).assertIsDisplayed()
    }
}
