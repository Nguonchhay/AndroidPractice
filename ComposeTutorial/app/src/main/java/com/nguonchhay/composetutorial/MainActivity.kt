package com.nguonchhay.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguonchhay.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme (
                darkTheme = false
            ) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

//                    Row {
//                        Greeting("Android Jetpack Compose")
//                    }

//                    MessageCard(message = Message("Nguonchhay", "Welcome to Android Jetpack Compose"))
                    Conversation(
                        listOf(
                            Message("Nguonchhay", "Welcome to Android Jetpack Compose"),
                            Message("Sok", "Party at weekend!")
                        )
                    )
                }
            }
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(
        modifier = Modifier.padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Default icon",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black)
        )
        
        Spacer(modifier = Modifier.padding(all = 15.dp))
        
        Column {
            Text(message.author)
            Spacer(modifier = Modifier.padding(all = 5.dp))
            Text(message.body)
        }
    }
}

@Composable
fun Conversation(list: List<Message>) {
    LazyColumn {
        items(list) { message ->
            MessageCard(message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
//        Row {
//            Greeting("Android Jetpack Compose")
//        }

        MessageCard(message = Message("Nguonchhay", "Welcome to Android Jetpack Compose"))
        MessageCard(message = Message("Sok", "Party at weekend!"))
    }
}