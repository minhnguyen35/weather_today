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
WeatherForecast("San francisco","cloudy1",
30.0, 300.0, 330.0,
"2024-06-28 22:00", 4334934L),
WeatherForecast("San francisco","cloudy 2",
30.0, 300.0, 330.0,
"April,30th 12h", 4334934L),
WeatherForecast("San francisco","cloudy3",
30.0, 300.0, 330.0,
"April,30th 14h", 4334934L),
WeatherForecast("San francisco","cloudy 4",
30.0, 300.0, 330.0,
"April,30th 18h", 4334934L),
WeatherForecast("San francisco","cloudy 5",
30.0, 300.0, 330.0,
"April,30th 15:00", 4334934L),
WeatherForecast("San francisco","cloudy 6",
30.0, 300.0, 330.0,
"April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy1",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy 2",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy3",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy 4",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy 5",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L),
    WeatherForecast("San francisco","cloudy 6",
        30.0, 300.0, 330.0,
        "April,30th 15:00", 4334934L)
)