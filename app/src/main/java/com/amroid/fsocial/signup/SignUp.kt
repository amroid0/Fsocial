package com.amroid.fsocial.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.amroid.fsocial.R

@Composable
@Preview(device = Devices.PIXEL_4)

fun SignUp() {
    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        Text(text = "create Account")
        OutlinedTextField(value = "", onValueChange = {},
            label = {
                Text(text = stringResource(id = R.string.email))
            })

        OutlinedTextField(value = "", onValueChange = {},
            label = {
                Text(text = stringResource(id = R.string.password))
            }
        )
        Button(onClick = {}) {
            Text(text = stringResource(id = R.string.signup))
        }
    }

}