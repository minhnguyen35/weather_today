package com.minhnguyen.forecasts

import com.minhnguyen.network.models.Network3HoursForecast

interface ForecastByCityDataSource {
    suspend fun getForecast(city: String): Network3HoursForecast
}