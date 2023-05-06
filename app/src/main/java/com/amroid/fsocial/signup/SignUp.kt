package com.amroid.fsocial.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amroid.fsocial.R

@Composable
@Preview(device = Devices.PIXEL_4)

fun SignUp() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.create_account), style = typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        EmailField(value = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))
        PasswordField(value = password, onValueChange = { password = it })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.signup))
        }

    }

}

@Composable
private fun PasswordField(value: String, onValueChange: (String) -> Unit) {
    var isVisible by remember {
        mutableStateOf(false)
    }
    val visualTransform =
        if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
    OutlinedTextField(value = value,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(id = R.string.password))
        },
        trailingIcon = {
            ToggleVisibility(isVisible = isVisible) {
                isVisible = !isVisible
            }
        },
        visualTransformation = visualTransform
    )
}

@Composable
private fun ToggleVisibility(isVisible: Boolean, onToggle: () -> Unit) {

    IconButton(onClick = {
        onToggle()
    }) {
        val resource =
            if (isVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
        Icon(painter = painterResource(id = resource), contentDescription = "toggleVisbilty")
    }


}

@Composable
private fun EmailField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(id = R.string.email))
        })
}
