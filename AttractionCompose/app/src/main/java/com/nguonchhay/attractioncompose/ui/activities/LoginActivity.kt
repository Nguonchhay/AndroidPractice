package com.nguonchhay.attractioncompose.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguonchhay.attractioncompose.R
import com.nguonchhay.attractioncompose.ui.activities.ui.theme.AttractionComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttractionComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    // State
    var emailState = remember { mutableStateOf(TextFieldValue()) }
    var passwordState = remember { mutableStateOf(TextFieldValue()) }

    // Layout
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(15.dp)
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        
        OutlinedTextField(
            value = emailState.value,
            label = { Text("Email Address") },
            singleLine = true,
            onValueChange = { emailState.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.padding(4.dp))

        OutlinedTextField(
            value = passwordState.value,
            label = { Text("Password") },
            singleLine = true,
            onValueChange = { passwordState.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(15.dp))

        Button(
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ),
            onClick = {
                if (emailState.value.text == "" || passwordState.value.text == "") {
                    Toast.makeText(context, "Field are require!", Toast.LENGTH_SHORT).show()
                } else {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            },
        ) {
            Text(
                text = "Login"
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "Forgot Password",
            color = Color.Cyan,
            modifier = Modifier.padding(30.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "Create New Account",
            color = Color.Blue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AttractionComposeTheme {
        LoginScreen()
    }
}