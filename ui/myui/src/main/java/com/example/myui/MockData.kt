package com.example.myui

import androidx.compose.ui.graphics.Color
import com.example.models.WeatherForecast

val colorStops = arrayOf(
    0.0f to Color(0xFF201982),
    1f to Color(0xffb520e3)
)
val colorStopsMain = arrayOf(
    0.0f to Color(0xFF201982),
    0.8f to Color(0xffb520e3)
)
val mockData = listOf(
WeatherForecast(1,"San francisco","cloudy1",
30.0, 23.0, 27.0,
"10h"),
WeatherForecast(1,"San francisco","cloudy 2",
30.0, 23.0, 27.0,
"12h"),
WeatherForecast(1,"San francisco","cloudy3",
30.0, 23.0, 27.0,
"14h"),
WeatherForecast(1,"San francisco","cloudy 4",
30.0, 23.0, 27.0,
"18h"),
WeatherForecast(1,"San francisco","cloudy 5",
30.0, 23.0, 27.0,
"112233"),
WeatherForecast(1,"San francisco","cloudy 6",
30.0, 23.0, 27.0,
"112233"),
    WeatherForecast(1,"San francisco","cloudy1",
        30.0, 23.0, 27.0,
        "112233"),
    WeatherForecast(1,"San francisco","cloudy 2",
        30.0, 23.0, 27.0,
        "112233"),
    WeatherForecast(1,"San francisco","cloudy3",
        30.0, 23.0, 27.0,
        "112233"),
    WeatherForecast(1,"San francisco","cloudy 4",
        30.0, 23.0, 27.0,
        "112233"),
    WeatherForecast(1,"San francisco","cloudy 5",
        30.0, 23.0, 27.0,
        "112233"),
    WeatherForecast(1,"San francisco","cloudy 6",
        30.0, 23.0, 27.0,
        "112233")
)