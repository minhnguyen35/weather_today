package com.example.myui

import com.example.models.WeatherForecast

data class HomeScreenState(
    val avgTemperature: String,
    val maxTemperature: String,
    val minTemperature: String,
    val cityName: String,
    val descriptionForecast: String,
    val dayTimestamp: String,
    val todayForecasts: List<WeatherForecast>
) {
    companion object {
        val Empty = HomeScreenState(
            "","","","","",
            "Today", emptyList())
    }
}