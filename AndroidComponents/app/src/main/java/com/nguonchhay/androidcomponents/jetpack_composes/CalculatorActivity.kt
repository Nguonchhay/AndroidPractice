package com.nguonchhay.androidcomponents.jetpack_composes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguonchhay.androidcomponents.R
import com.nguonchhay.androidcomponents.jetpack_composes.ui.theme.AndroidComponentsTheme
import com.nguonchhay.androidcomponents.jetpack_composes.viewmodels.CalculatorState
import com.nguonchhay.androidcomponents.jetpack_composes.viewmodels.CalculatorViewModel

class CalculatorActivity : ComponentActivity() {

    val calculatorViewModel by viewModels<CalculatorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CompositionLocalProvider(CalculatorState provides  calculatorViewModel) {
                        CalculatorContent()
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatorContent() {

    val vm = CalculatorState.current
    var value1 by remember { mutableStateOf(TextFieldValue("")) }
    var value2 by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.minion1),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        )

        Text(
            text = "Simple Calculator",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row {
            Column() {
                OutlinedTextField(
                    value = value1,
                    label = { Text(text = "Value 1") },
                    onValueChange = {
                        value1 = it
                    }
                )
            }
        }

        Row {
            Column() {
                OutlinedTextField(
                    value = value2,
                    label = { Text(text = "Value 2") },
                    onValueChange = {
                        value2 = it
                    }
                )
            }
        }

        Row {
            Column() {
                OutlinedTextField(
                    value = TextFieldValue(vm.resultState.value.toString()),
                    label = { Text(text = "Result") },
                    onValueChange = {
                    }
                )
            }
        }

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    vm.doSum(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " + ")
            }

            Button(
                onClick = {
                    vm.doMinus(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " - ")
            }

            Button(
                onClick = {
                    vm.doMul(value1.text.toDouble(), value2.text.toDouble())
                }
            ) {
                Text(text = " * ")
            }

            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(text = " / ")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComponentsTheme {
        CalculatorContent()
    }
}