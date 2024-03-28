package com.example.openweather

import com.example.openweather.models.Network3HoursForecast

interface OWNetworkDataSource {
    suspend fun getForecastsByCityName(city: String): List<Network3HoursForecast>
}