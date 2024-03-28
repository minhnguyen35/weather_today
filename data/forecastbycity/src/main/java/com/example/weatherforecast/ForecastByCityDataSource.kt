package com.example.weatherforecast

import com.example.models.WeatherForecast

interface ForecastByCityDataSource {
    suspend fun getForecast(city: String): List<WeatherForecast>
}