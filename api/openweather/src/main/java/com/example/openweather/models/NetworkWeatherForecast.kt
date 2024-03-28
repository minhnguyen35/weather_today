package com.example.openweather.models

import kotlinx.serialization.SerialName

data class NetworkWeatherForecast(
    @SerialName("dt")
    val dt: Long,

    @SerialName("main")
    val main: NetworkForecastMainSpecs,

    @SerialName("weather")
    val weather: List<NetworkWeatherDesc>,

    @SerialName("clouds")
    val clouds: Double,

    @SerialName("wind")
    val wind: NetworkWind,

    @SerialName("visibility")
    val visibility: Long,

    @SerialName("pop")
    val pop: Double,

    @SerialName("rain")
    val rain3h: Double,

    @SerialName("snow")
    val snow3h: Double,

    @SerialName("sys")
    val mSys: String,

    @SerialName("dt_txt")
    val timeForecasts: String
)
