package com.example.aroapp.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUp(
    onNavigateToLogin: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confPassword by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            fontSize = 24.sp
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = email,
            placeholder = { Text(text = "user@email.com") },
            label = { Text(text = "email") },
            onValueChange = { email = it},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "password") },
            label = { Text(text = "password") },
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        OutlinedTextField(
            value = confPassword,
            placeholder = { Text(text = "password") },
            label = { Text(text = "confirm password") },
            onValueChange = { confPassword = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(
            onClick = {
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Sign up",
                modifier = Modifier.padding(all = 8.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        TextButton(onClick = onNavigateToLogin) {
            Text(text = "Login")
        }
    }
}