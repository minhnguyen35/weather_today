package com.minhnguyen.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinate(
    @SerialName("lon")
    val lon: Double,
    @SerialName("lat")
    val lat: Double,
)