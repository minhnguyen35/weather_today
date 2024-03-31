package com.minhnguyen.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Network3HoursForecast(
    @SerialName("cod")
    val cod: String = "",
    @SerialName("message")
    val message: Double = 0.0,
    @SerialName("cnt")
    val cnt: Int = 0,
    @SerialName("city")
    val city: City? = null,
    @SerialName("list")
    val list: List<NetworkWeatherForecast> = emptyList()
)