package com.example.openweather.models

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class NetworkLocation(
    val id: Int,
    val name: String,
    val countryCode: String,
    val sunriseTime: LocalDateTime,
    val coord: Coordinate,
)
