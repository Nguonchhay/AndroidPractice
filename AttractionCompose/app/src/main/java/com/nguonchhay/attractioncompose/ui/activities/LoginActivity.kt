package com.nguonchhay.attractioncompose.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.nguonchhay.attractioncompose.R
import com.nguonchhay.attractioncompose.entities.UserEntity
import com.nguonchhay.attractioncompose.ui.activities.ui.theme.AttractionComposeTheme
import com.nguonchhay.attractioncompose.ui.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.collectLatest

class LoginActivity : ComponentActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContent {
            AttractionComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(loginViewModel)
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            loginViewModel.uiState.collectLatest {
                if (it.user != null) {
                    if (it.user.id != null) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }  else {
                        Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

fun loginAction(loginViewModel: LoginViewModel, user: UserEntity) {
    loginViewModel.login(user)
}

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    val context = LocalContext.current
    // State
    val emailState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }

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
                    Toast.makeText(context, "Fields are required!", Toast.LENGTH_SHORT).show()
                } else {
                    loginAction(
                        loginViewModel,
                        UserEntity(
                            email = emailState.value.text,
                            password = passwordState.value.text
                        )
                    )
                }
            }
        ) {
            Text(
                text = "Login"
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "Forgot Password",
            color = colorResource(id = R.color.purple_200),
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
        //LoginScreen()
    }
}