package com.example.rgbcolormixer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rgbcolormixer.ui.theme.RGBColorMixerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RGBColorMixerTheme {
                ColorMixerScreen()
            }
        }
    }
}

@Composable
fun ColorMixerScreen() {
    // Storing thee RGB values as mutable state
    val red = remember { mutableFloatStateOf(0f) }
    val green = remember { mutableFloatStateOf(0f) }
    val blue = remember { mutableFloatStateOf(0f) }

    // Converting float values to int for Color
    val color = Color(red.value.toInt(), green.value.toInt(), blue.value.toInt())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Adjust Red: ${red.value.toInt()}")
        Slider(
            value = red.value,
            onValueChange = { red.value = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red
            )
        )

        Text(text = "Adjust Green: ${green.value.toInt()}")
        Slider(
            value = green.value,
            onValueChange = { green.value = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green
            )
        )

        Text(text = "Adjust Blue: ${blue.value.toInt()}")
        Slider(
            value = blue.value,
            onValueChange = { blue.value = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue
            )
        )

        // Displaying da mixed color
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color)
        )

        Text(
            text = "RGB: (${red.value.toInt()}, ${green.value.toInt()}, ${blue.value.toInt()})",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColorMixerScreenPreview() {
    RGBColorMixerTheme {
        ColorMixerScreen()
    }
}
