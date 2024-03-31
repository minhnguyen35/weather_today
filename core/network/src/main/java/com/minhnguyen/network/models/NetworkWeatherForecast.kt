package com.minhnguyen.network.models

import com.example.openweather.models.NetworkWeatherDesc
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkWeatherForecast(
    @SerialName("dt")
    val dt: Long,

    @SerialName("main")
    val main: NetworkForecastMainSpecs,

    @SerialName("weather")
    val weather: List<NetworkWeatherDesc>,

    @SerialName("clouds")
    val clouds: NetworkCloud,

    @SerialName("wind")
    val wind: NetworkWind,

    @SerialName("visibility")
    val visibility: Long,

    @SerialName("pop")
    val pop: Double,

//    @SerialName("rain")
//    val rain3h: Double,
//
//    @SerialName("snow")
//    val snow3h: Double,
//
    @SerialName("sys")
    val mSys: NetworkSys,

    @SerialName("dt_txt")
    val timeForecasts: String
)
