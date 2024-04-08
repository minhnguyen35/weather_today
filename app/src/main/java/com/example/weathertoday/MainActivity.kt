package com.example.weathertoday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myui.HomeScreen
import com.example.weathertoday.ui.WeatherTodayApp
import com.example.weathertoday.ui.theme.WeatherTodayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTodayTheme {
                // A surface container using the 'background' color from the theme
                WeatherTodayApp()
            }
        }
    }
}


@Preview
@Composable
fun AppPreview() {
    WeatherTodayTheme {
        WeatherTodayApp()
    }
}