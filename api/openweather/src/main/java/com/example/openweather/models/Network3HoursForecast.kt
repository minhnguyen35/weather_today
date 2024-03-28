package com.example.openweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Network3HoursForecast(
    @SerialName("cod")
    val cod: String,
    @SerialName("message")
    val message: Double,
    @SerialName("cnt")
    val cnt: Int,
    @SerialName("city")
    val location: City,
    @SerialName("list")
    val forecasts: NetworkWeatherForecast
)