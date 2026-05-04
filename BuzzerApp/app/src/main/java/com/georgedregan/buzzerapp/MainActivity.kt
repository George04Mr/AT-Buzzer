package com.georgedregan.buzzerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {

    private val serverIp = "192.168.1.137:5000" // CHANGE THIS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuzzerApp(serverIp)
        }
    }
}

@Composable
fun BuzzerApp(serverIp: String) {
    var status by remember { mutableStateOf("Idle") }

    fun sendCommand(song: String) {
        status = "Sending $song..."
        thread {
            try {
                URL("http://$serverIp/play?song=$song").readText()
                status = "Played: $song"
            } catch (e: Exception) {
                status = "Error: ${e.message}"
            }
        }
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { sendCommand("beep") }) {
                    Text("Beep")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { sendCommand("scale") }) {
                    Text("Scale")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { sendCommand("melody") }) {
                    Text("Melody")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { sendCommand("ode") }) {
                    Text("Ode to Joy")
                }
            }
        }
    }
}

