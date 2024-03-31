package com.minhnguyen.forecasts

import com.example.openweather.models.NetworkWeatherDesc
import com.minhnguyen.network.models.Network3HoursForecast
import com.minhnguyen.network.models.NetworkWeatherForecast

interface ForecastByCityDataSource {
    suspend fun getForecast(city: String): Network3HoursForecast
}