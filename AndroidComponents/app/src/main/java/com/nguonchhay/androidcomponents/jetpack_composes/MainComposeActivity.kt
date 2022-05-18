package com.nguonchhay.androidcomponents.jetpack_composes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.nguonchhay.androidcomponents.jetpack_composes.ui.theme.AndroidComponentsTheme

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val context = LocalContext.current

    Column {
        Button(
            onClick = {
                context.startActivity(Intent(context, CalculatorActivity::class.java))
            }
        ) {
            Text(text = "Calculator")
        }

        Button(
            onClick = {
                context.startActivity(Intent(context, BottomNavActivity::class.java))
            }
        ) {
            Text(text = "Bottom Navigation")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AndroidComponentsTheme {
        MainContent()
    }
}