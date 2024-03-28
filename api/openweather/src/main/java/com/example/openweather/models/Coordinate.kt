package com.example.openweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinate(
    @SerialName("lon")
    val lon: Double,
    @SerialName("lat")
    val lat: Double,
)