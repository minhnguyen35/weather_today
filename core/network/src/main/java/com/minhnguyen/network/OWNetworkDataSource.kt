package com.minhnguyen.network

import com.minhnguyen.network.models.Network3HoursForecast

interface OWNetworkDataSource {
    suspend fun getForecastsByCityName(city: String): Network3HoursForecast
}