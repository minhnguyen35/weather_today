package com.example.openweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class City(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("coord")
    val coord: Coordinate,

    @SerialName("country")
    val country: String,

    @SerialName("timezone")
    val timezone: Long,

    @SerialName("population")
    val population: Long,

    @SerialName("sunrise")
    val sunrise: Long,

    @SerialName("sunset")
    val sunset: Long
)
