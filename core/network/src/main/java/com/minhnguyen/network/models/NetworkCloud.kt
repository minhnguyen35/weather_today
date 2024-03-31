package com.minhnguyen.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCloud(
    @SerialName("all")
    val all: Double
)