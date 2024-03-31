package com.minhnguyen.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkWind(
    @SerialName("speed")
    val speed: Double,
    @SerialName("deg")
    val deg: Double,
    @SerialName("gust")
    val gust: Double
)
