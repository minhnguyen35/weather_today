package com.example.openweather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSys(
    @SerialName("sys")
    val partOfDay: String
)
