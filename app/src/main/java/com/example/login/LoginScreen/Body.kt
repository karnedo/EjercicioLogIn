package com.example.login.LoginScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.util.PatternsCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(modifier: Modifier){
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
        Title()
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) {
            email = it
            if (password.length > 0 && email.length > 0 && isValidEmail(email))
                isLoginEnable = true
            else
                isLoginEnable = false
        }
        Spacer(modifier = Modifier.size(16.dp))
        Password(password) {
            password = it
            if (password.length > 0 && email.length > 0 && isValidEmail(email))
                isLoginEnable = true
            else
                isLoginEnable = false
        }
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
    }
}

@Composable
fun Title(){
    Text(
        text = "Sign in",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        color = Color(0xFF000000)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { onTextChanged(it)
                        text = it},
        modifier = Modifier
            .border(1.dp, Color(0xFF005897), RoundedCornerShape(5.dp))
            .fillMaxWidth(),
        label={Text(text="USERNAME", fontSize = 13.sp)},
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            if (text.isNotEmpty() and isValidEmail(text)) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(25.dp))
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF000000),
            containerColor = Color(0xFFFFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(email: String, onTextChanged: (String) -> Unit) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { onTextChanged(it)
            text = it},
        modifier = Modifier
            .border(1.dp, Color(0xFF005897), RoundedCornerShape(5.dp))
            .fillMaxWidth(),
        label={Text(text="PASSWORD", fontSize = 13.sp)},
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            if (text.isNotEmpty()) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(25.dp))
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF000000),
            containerColor = Color(0xFFFFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = { /*TODO*/ }, enabled = loginEnable,
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContentColor = Color.White,
            contentColor = Color.White,
            containerColor = Color(0xFF005897),
            disabledContainerColor = Color(0xFF5793BB)
        )
    ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = null, modifier = Modifier.size(25.dp))
    }
}

private fun isValidEmail(email: String): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
}